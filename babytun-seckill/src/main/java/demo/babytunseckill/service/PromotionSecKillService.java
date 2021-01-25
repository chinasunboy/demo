package demo.babytunseckill.service;


import demo.babytunseckill.dao.OrderDAO;
import demo.babytunseckill.dao.PromotionSecKillDAO;
import demo.babytunseckill.entity.Order;
import demo.babytunseckill.entity.PromotionSecKill;
import demo.babytunseckill.service.exception.SecKillException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//利用redis单线程与高并发量的特性来解决高并与超卖问题
//购买逻辑：判断活动是否存在，是否正在进行，ID是否重复购买，商品list弹出，用户set加入
@Service
public class PromotionSecKillService {
    @Resource
    private PromotionSecKillDAO promotionSecKillDAO;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource //RabbitMQ客户端
    private RabbitTemplate rabbitTemplate;

    @Resource
    private OrderDAO orderDAO;

    //商品购买逻辑 ，
    //               商品id       用户id       用户可以抢购的数量
    public void processSecKill(Long psId, String userid, Integer num) throws SecKillException {
        //查询秒杀商品信息是否存在
        PromotionSecKill ps = promotionSecKillDAO.findById(psId);
        if (ps == null) {
            //秒杀活动不存在
            throw new SecKillException("秒杀活动不存在");
        }
        if (ps.getStatus() == 0) {
            throw new SecKillException("秒杀活动还未开始");
        } else if (ps.getStatus() == 2) {
            throw new SecKillException("秒杀活动已经结束");
        }
        //弹出商品
        Integer goodsId = (Integer) redisTemplate.opsForList().leftPop("seckill:count:" + ps.getPsId());
        if (goodsId != null) {
            //判断是否已经抢购过
            boolean isExisted = redisTemplate.opsForSet().isMember("seckill:users:" + ps.getPsId(), userid);
            if (!isExisted) {
                System.out.println("恭喜您，抢到商品啦。快去下单吧");
                redisTemplate.opsForSet().add("seckill:users:" + ps.getPsId(), userid);
            } else {
                //重新加入reids秒杀商品数量
                redisTemplate.opsForList().rightPush("seckill:count:" + ps.getPsId(), ps.getGoodsId());
                throw new SecKillException("抱歉，您已经参加过此活动，请勿重复抢购！");
            }
        } else {
            throw new SecKillException("抱歉，该商品已被抢光，下次再来吧！！");
        }

    }

    //想rabbitmq消息队列发送信息
    public String sendOrderToQueue(String userid) {
        System.out.println("准备向队列发送信息");
        //订单基本信息
        Map data = new HashMap();
        data.put("userid", userid);
        String orderNo = UUID.randomUUID().toString();
        data.put("orderNo", orderNo);
        //附加额外的订单信息                      交换器                 路由件             数据
        rabbitTemplate.convertAndSend("exchange-order" , null , data);
        //返回随机订单号
        return orderNo;
    }

    //检查订单
    public Order checkOrder(String orderNo){
        Order order = orderDAO.findByOrderNo(orderNo);
        return order;
    }

}

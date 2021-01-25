package demo.babytunseckill.scheduler;


import demo.babytunseckill.dao.PromotionSecKillDAO;
import demo.babytunseckill.entity.PromotionSecKill;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
//定时任务   主要利用redis来解决高并发与超卖问题 开始与结束
//数据库秒杀商品信息的状态为0且时间合适时，自动启动，查询并创建秒杀商品数量的list对象。状态改为1
//每5s查询是否存在失效秒杀活动，状态改为3，并将redis缓存中删除剩余的list商品对象
@Component
public class SecKillTask {
    @Resource
    private PromotionSecKillDAO promotionSecKillDAO;
    //RedisTempldate是Spring封装的Redis操作类，提供了一系列操作redis的模板方法
    @Resource
    private RedisTemplate redisTemplate;
    @Scheduled(cron = "0/5 * * * * ?")
    public void startSecKill(){
        //查询秒杀的商品信息
        List<PromotionSecKill> list  = promotionSecKillDAO.findUnstartSecKill();
        for(PromotionSecKill ps : list){
            System.out.println(ps.getPsId() + "秒杀活动已启动");
            //删掉以前重复的活动任务缓存
            redisTemplate.delete("seckill:count:" + ps.getPsId());
            //有几个库存商品，则初始化几个list对象
            for(int i = 0 ; i < ps.getPsCount() ; i++){
                System.out.println(i);
                redisTemplate.opsForList().rightPush("seckill:count:" + ps.getPsId() , ps.getGoodsId());
            }
            //秒杀商品信息为0时，开始。改为了1为进行，2为结束
            ps.setStatus(1);
            //将秒杀状态更新
            promotionSecKillDAO.update(ps);
        }
    }
    @Scheduled(cron = "0/5 * * * * ?")
    public void endSecKill(){
        //查询时间结束的秒杀活动
        List<PromotionSecKill> psList = promotionSecKillDAO.findExpireSecKill();
        for (PromotionSecKill ps : psList) {
            System.out.println(ps.getPsId() + "秒杀活动已结束");
            ps.setStatus(2);
            promotionSecKillDAO.update(ps);
            redisTemplate.delete("seckill:count:" + ps.getPsId());
        }
    }

}

package demo.babytunseckill.controller;


import demo.babytunseckill.entity.Order;
import demo.babytunseckill.service.PromotionSecKillService;
import demo.babytunseckill.service.exception.SecKillException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SecKillController {
    @Resource
    PromotionSecKillService promotionSecKillService;

    @RequestMapping("/seckill")
    @ResponseBody
    public Map processSecKill(Long psid , String userid){
        Map result = new HashMap();
        try {
            //购买商品
            promotionSecKillService.processSecKill(psid , userid , 1);
            //想消息队列发送用户并返回订单号
            String orderNo = promotionSecKillService.sendOrderToQueue(userid);
            Map data = new HashMap();
            data.put("orderNo", orderNo);
            result.put("code", "0");
            result.put("message", "success");
            result.put("data", data);
        } catch (SecKillException e) {
            result.put("code", "500");
            result.put("message", e.getMessage());
        }
        //返回成功信息
        return result;
    }

    //页面利用ajax3s刷新一次订单状态
    //确认订单是否完成
    @GetMapping("/checkorder")
    public ModelAndView checkOrder(String orderNo){
        //订单创建是否成功，是就返回
        Order order =  promotionSecKillService.checkOrder(orderNo);
        ModelAndView mav = new ModelAndView();
        if(order != null){
            mav.addObject("order", order);
            mav.setViewName("/order");
        }else{
            mav.addObject("orderNo", orderNo);
            mav.setViewName("/waiting");
        }
        return mav;
    }
}

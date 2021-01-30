package demo.springbootreviewrabbitmq;

import com.fasterxml.jackson.annotation.JsonAlias;
import demo.springbootreviewrabbitmq.Employee;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

//一定记得序列化
@Component
public class MessageProduce {

    @Resource
    RabbitTemplate rabbitTemplate;

    //springBoot默认不显示rabbitmq错误信息，需要重写
    RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        /**
         * correlationData 消息的附加信息
         * isAck为是否返回信息
         * cause如果拒收则说明原因，帮助我们进行后续处理
         */
        public void confirm(CorrelationData correlationData, boolean isAck, String cause) {
            System.out.println(correlationData);
            System.out.println("ACK ："+isAck);
            if (isAck == false) System.err.println(cause);
        }
    };

//    RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
//        @Override
//        /**
//         * replayCode 错误编码
//         * replayText 错误描述
//         * exchange 交换机
//         * routingKry 路由键
//         */
//        public void returnedMessage(Message message, int replayCode, String replayText, String exchange, String routingKey) {
//            System.err.println("replayCode"+replayCode+"----"+"replayCode"+replayCode);
//            System.err.println("exchange"+exchange+"----"+"routingKey"+routingKey);
//        }
//    };

    RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        /**
         * replayCode 错误编码
         * replayText 错误描述
         * exchange 交换机
         * routingKry 路由键
         */
        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingkey) {
            System.err.println("Code:" + replyCode + ",Text:" + replyText );
            System.err.println("Exchange:" + exchange + ",RoutingKey:" + routingkey );
        }
    };


    public void sendMessage(String str){
        //作用为作为消息的附加传递信息 ，生成全局唯一变量，规则为时间戳
        //CorrelationData correlationData = new CorrelationData(employee.getEmpno()+"-"+ new Date().getTime());
        //将上面重新的对象放进来

        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        //                                             交换机                          路由键             对象      附加信息
        rabbitTemplate.convertAndSend("springBoot-review-exchange","springboot-queue", str );
    }
}

package demo.springbootreviewrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootReviewRabbitmqApplicationTests {


    @Resource
    MessageProduce messageProduce;

    @Test
    void contextLoads() {
        messageProduce.sendMessage("大傻逼");
}

}

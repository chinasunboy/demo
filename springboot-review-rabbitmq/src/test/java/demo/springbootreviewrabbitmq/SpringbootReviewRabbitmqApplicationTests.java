package demo.springbootreviewrabbitmq;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootReviewRabbitmqApplicationTests {


    @Resource
    MessageProduce messageProduce;

    @Test
    void contextLoads() {
        messageProduce.sendMessage(new Employee("3306","勾吧",18));
}
    @Test
    void test() {
        byte[] s = JSON.toJSONBytes(new Employee("3306", "大傻逼", 18));
        System.out.println(s);
        Employee employee = JSON.parseObject(s, Employee.class);
        System.out.println(employee);
    }
}

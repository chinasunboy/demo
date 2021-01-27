package demo.springbootreviewtestmybatis;

import demo.springbootreviewtestmybatis.Service.AccountService;
import demo.springbootreviewtestmybatis.entity.Account;
import demo.springbootreviewtestmybatis.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootReviewTestmybatisApplicationTests {

    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;

    @Test
    void contextLoads() {
        System.out.println(accountService.findAll());
//        Account account = new Account();
//        account.setId(1);
//        account.setName("小傻逼");
//        account.setMoney(1000);
//        accountService.updateAccount(account);
//        System.out.println(accountService.findAll());

    }

    @Test
    void Jpatest(){
        List<Account> all = accountRepository.findAll();
        System.out.println(all);
        System.out.println(accountRepository.findById(1));
    }

}

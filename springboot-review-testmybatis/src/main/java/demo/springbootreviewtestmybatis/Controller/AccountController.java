package demo.springbootreviewtestmybatis.Controller;

import demo.springbootreviewtestmybatis.Service.AccountService;
import demo.springbootreviewtestmybatis.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account/{id}")
    public Account findId(@PathVariable Integer id){
        return accountService.findId(id);
    }
}

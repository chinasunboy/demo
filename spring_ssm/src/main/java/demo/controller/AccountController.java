package demo.controller;

import demo.domain.Account;
import demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有用户信息。。。");
        List<Account> accounts = accountService.findAll();
        model.addAttribute("list",accounts);
        return "list";
    }

    @RequestMapping("/testSave")
    public void testSave(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层：查询所有用户信息。。。");
       accountService.saveAccount(account);
       response.sendRedirect(request.getContextPath()+"/account/findAll");

    }

}

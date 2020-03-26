package demo.controller;


import demo.domain.Product;
import demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * web层控制器
 * 调用Service层实现类对象来实现spring整合MVC
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;


    //查询全部产品
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")//jsr250权限注解
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = iProductService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list");
        return mv;
    }

    //产品添加
    @RequestMapping("/save.do")
    public String findAll(Product product) throws Exception {
        System.out.println(product);
        iProductService.save(product);
        return "redirect:findAll.do";
    }
}

package com.invoicing.controller;

import com.invoicing.entity.Product;
import com.invoicing.entity.Users;
import com.invoicing.service.IProductService;
import com.invoicing.service.IUsersService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Created by FLC on 2018/4/18.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUsersService iUsersService;
    @Resource
    private IProductService iProductService;


    @RequestMapping("/login")
    public String login(String userName, String password, HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        System.out.println("接收的值为：" + userName + ":" + password);
        Users users = iUsersService.doLogin(userName,password);
        if (users == null) {
            response.setContentType("text/html; charset=UTF-8"); //转码
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('用户名或者密码错误！');");
            out.println("</script>");
            return "/login";
        }
        else{
            /**
             * 登陆成功跳转main.html
             */
            request.getSession().setAttribute("user", users);
            List<Product> productList = iProductService.getProductList();
            request.getSession().setAttribute("prolist",productList);
            model.addAttribute("usermodel", users);
            model.addAttribute("productList",productList);
            return "/main";
        }

    }

    @RequestMapping("/loginout")
    public String loginout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "/login";
    }
}

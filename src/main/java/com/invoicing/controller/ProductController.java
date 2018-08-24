package com.invoicing.controller;

import com.alibaba.fastjson.JSON;
import com.invoicing.entity.Product;
import com.invoicing.service.IProductService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by FLC on 2018/4/18.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private IProductService iProductService;
    @RequestMapping("/getProductById")
    @ResponseBody
    public void getProductById(Integer id,HttpServletResponse response) throws IOException {

        Product productById = iProductService.getProductById(id);
        Integer quantity = productById.getQuantity();
        String s = JSON.toJSONString(quantity);
        response.getWriter().write(s);


    }
}

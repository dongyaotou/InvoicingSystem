package com.invoicing.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.invoicing.entity.Product;
import com.invoicing.entity.Sale;
import com.invoicing.entity.Users;
import com.invoicing.service.IProductService;
import com.invoicing.service.ISaleService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by FLC on 2018/4/18.
 */
@Controller
@RequestMapping("/sale")
public class SaleController {
    @Resource
    private ISaleService iSaleService;
    @Resource
    private IProductService iProductService;

    @RequestMapping("/insertSale")
    public String insertSale(Sale sale, HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        //验证库存
        Users user = (Users) request.getSession().getAttribute("user");
        List<Product> prolist = (List<Product>) request.getSession().getAttribute("prolist");
        model.addAttribute("usermodel", user);
        model.addAttribute("productList",prolist);
        Product productById = iProductService.getProductById(sale.getProductId());
        System.out.println("productById============"+sale.getQuantitys());
        if (sale.getQuantitys() > productById.getQuantity()) {
            response.setContentType("text/html; charset=UTF-8"); //转码
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('库存不足！');");
            out.println("</script>");
            return "/main";
        } else {
            //修改库存

            Integer number = productById.getQuantity() - sale.getQuantitys();
            iProductService.updateProduct(number, sale.getProductId());
            //添加记录

            System.out.println("userid==============" + user.getId());
            Sale sales = new Sale();
            sales.setPrice(sale.getPrice());
            sales.setQuantitys(sale.getQuantitys());

            sales.setProductId(sale.getProductId());

            sales.setSaleDate(new Date());
            sales.setTotalPrice(sale.totalPrices(sale.getQuantitys(),sale.getPrice()));
            sales.setUserId(user.getId());
            int i = iSaleService.insertSale(sales);
            if(i>=0)
            {
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('添加成功！');");
                out.println("</script>");
                return "/main";
            }
            else{
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('添加失败！');");
                out.println("</script>");
                return "/main";
            }

        }


    }
    @RequestMapping("/salelist")
    @ResponseBody
    public void saleList(@RequestParam(value="order", defaultValue="销售日期")String order, @RequestParam(required = false, defaultValue="1")int pageNum, @RequestParam(required = false, defaultValue="5")int pageSize,HttpServletResponse response) throws IOException {

        PageInfo<Sale> saleLists = iSaleService.getSaleList(order, (pageNum+1), pageSize);

        for (Sale u : saleLists.getList())
        {
            System.out.println("查询出来的id:"+u.getId());

        }
        for(Sale u : saleLists.getList()){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            String format1 = format.format(u.getSaleDate());
            u.setDatetime(format1);
        }
        response.setCharacterEncoding("utf-8");
        String s = JSON.toJSONString(saleLists);
        response.getWriter().write(s);


    }
}

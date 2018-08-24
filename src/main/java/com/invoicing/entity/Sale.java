package com.invoicing.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by FLC on 2018/4/18.
 */
public class Sale implements Serializable{
    private Integer id;     //订单id
    private double price;   //商品单价
    private Integer quantitys;       //商品数量
    private double totalPrice;  //商品总价
    private Date saleDate;      //销售日期
    private Integer userId;     //销售员id
    private Integer productId;  //商品 id
    private Product product;
    private Users users;
    private String datetime;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantitys() {
        return quantitys;
    }

    public void setQuantitys(Integer quantitys) {
        this.quantitys = quantitys;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 计算总价
     */
    public double totalPrices(Integer number,double price)
    {
        double totalprices=number*price;
        return totalprices;
    }
}

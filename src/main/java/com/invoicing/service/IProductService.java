package com.invoicing.service;

import com.invoicing.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by FLC on 2018/8/24.
 */
public interface IProductService {
    //查询
    public List<Product> getProductList();
    //查询库存
    public Product getProductById(Integer id);
    //修改库存
    int updateProduct(@Param("quantity") Integer quantity, @Param("id") Integer id);
}

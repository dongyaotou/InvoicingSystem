package com.invoicing.dao;

import com.invoicing.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by FLC on 2018/8/24.
 */
@Repository
public interface IProductDao {
    //查询
    public List<Product> getProductList();
    //查询库存
    public Product getProductById(Integer id);
    //修改库存
    int updateProduct(@Param("quantity") Integer quantity, @Param("id") Integer id);
}

package com.invoicing.service.impl;

import com.invoicing.dao.IProductDao;
import com.invoicing.entity.Product;
import com.invoicing.service.IProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by FLC on 2018/8/24.
 */
@Service("iProductServiceImpl")
public class IProductServiceImpl implements IProductService{
    @Resource
    private IProductDao iProductDao;
    @Override
    public List<Product> getProductList() {
        return iProductDao.getProductList();
    }

    @Override
    public Product getProductById(Integer id) {
        return iProductDao.getProductById(id);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    public int updateProduct(@Param("quantity") Integer quantity, @Param("id") Integer id) {
        return iProductDao.updateProduct(quantity,id);
    }
}

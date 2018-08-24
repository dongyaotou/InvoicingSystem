package com.invoicing.dao;

import com.invoicing.entity.Sale;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by FLC on 2018/8/24.
 */
@Repository
public interface ISaleDao {
    //销售
    public int insertSale(Sale sale);
    //查询
    public List<Sale> getSaleList(@Param("order")String order);
}

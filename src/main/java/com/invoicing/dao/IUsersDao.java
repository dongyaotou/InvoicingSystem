package com.invoicing.dao;

import com.invoicing.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by FLC on 2018/8/24.
 */
@Repository
public interface IUsersDao {
    //登录的方法
    public Users doLogin(@Param("username") String username, @Param("password") String password);

}

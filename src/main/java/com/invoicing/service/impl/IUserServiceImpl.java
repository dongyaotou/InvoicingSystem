package com.invoicing.service.impl;


import com.invoicing.dao.IUsersDao;
import com.invoicing.entity.Users;
import com.invoicing.service.IUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by FLC on 2018/8/24.
 */
@Service("iUserServiceImpl")
public class IUserServiceImpl implements IUsersService{
    @Resource
    private IUsersDao iUsersDao;


    @Override
    public Users doLogin(String username, String password) {
        return iUsersDao.doLogin(username,password);
    }
}

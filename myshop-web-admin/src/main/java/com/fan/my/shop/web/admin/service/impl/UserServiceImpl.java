package com.fan.my.shop.web.admin.service.impl;

import com.fan.my.shop.domain.TbUser;
import com.fan.my.shop.web.admin.dao.TBUserDao;
import com.fan.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TBUserDao tbUserDao;

    @Override
    public TbUser selectByLoginID(String loginId) {
        return tbUserDao.selectByLoginID(loginId);
    }

    @Override
    public int insertSelective(TbUser tbUser) {
        return tbUserDao.insertSelective(tbUser);
    }

    @Override
    public TbUser selectOne(TbUser tbUser) {
        return tbUserDao.selectOne(tbUser);
    }
}

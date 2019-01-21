package com.fan.my.shop.web.admin.service.impl;

import com.fan.my.shop.domain.TbUser;
import com.fan.my.shop.web.admin.dao.TestTableDao;
import com.fan.my.shop.web.admin.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestUserServiceImpl implements TestUserService {
    @Autowired
    private TestTableDao testTableDao;
    @Override
    public List<TbUser> selectAll() {
        return testTableDao.selectAll();
    }

    @Override
    public TbUser selectOne(TbUser tbUser) {
        return testTableDao.selectOne(tbUser);
    }
}

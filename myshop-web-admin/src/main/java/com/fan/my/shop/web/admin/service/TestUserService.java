package com.fan.my.shop.web.admin.service;

import com.fan.my.shop.domain.TbUser;

import java.util.List;

public interface TestUserService {
    List<TbUser> selectAll();
    TbUser  selectOne(TbUser tbUser);
}

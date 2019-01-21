package com.fan.my.shop.web.admin.service;

import com.fan.my.shop.domain.TbUser;
import com.fan.my.shop.domain.TbUserExample;

import java.util.List;

public interface UserService {
    TbUser selectByLoginID(String loginId);
    int insertSelective(TbUser tbUser);
    TbUser selectOne(TbUser tbUser);
}

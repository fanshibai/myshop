package com.fan.my.shop.web.admin.service;

import com.fan.my.shop.domain.TbUser;
import com.fan.my.shop.domain.TbUserExample;

import java.util.List;

public interface UserService {
    List<TbUser> selectByExample(TbUserExample example);
}

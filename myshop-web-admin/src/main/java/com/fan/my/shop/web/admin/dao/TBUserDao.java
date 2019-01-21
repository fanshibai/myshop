package com.fan.my.shop.web.admin.dao;

import com.fan.my.shop.domain.TbUser;
import com.fan.my.shop.domain.TbUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TBUserDao extends Mapper<TbUser> {
    TbUser selectByLoginID(String loginId);
}

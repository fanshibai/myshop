package com.fan.my.shop.web.admin.dao;

import com.fan.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface TestTableDao extends Mapper<TbUser> {
}

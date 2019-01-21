package com.fan.my.shop.web.admin.service.impl;

import com.fan.my.shop.domain.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)   //表示整合JUnit4进行测试
@ContextConfiguration(locations = {"classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml","classpath:spring-context.xml"})  //加载spring配置文件
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void selectByLoginID() {
        TbUser tbUser = userService.selectByLoginID("admin");
        if (tbUser==null){
            System.out.println(1);
        }else {
            System.out.println(tbUser.getUsername());
        }
    }
}
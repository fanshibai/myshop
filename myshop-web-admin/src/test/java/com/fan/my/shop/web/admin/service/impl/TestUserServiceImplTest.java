package com.fan.my.shop.web.admin.service.impl;

import com.fan.my.shop.domain.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)   //表示整合JUnit4进行测试
@ContextConfiguration(locations = {"classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml","classpath:spring-context.xml"})  //加载spring配置文件
public class TestUserServiceImplTest {
    @Autowired
    private TestUserServiceImpl testUserServiceImpl;
    @Test
    public void selectAll() {
        List<TbUser> tbUsers = testUserServiceImpl.selectAll();
        System.out.println(tbUsers.get(0).getEmail());
    }

    @Test
    public void selectOne() {
        TbUser tbUser = new TbUser();
        tbUser.setPhone("13570325844");
        tbUser.setEmail("809956159@qq.com");
    }

}
package servicetest;

import com.fan.my.shop.domain.TbUser;
import com.fan.my.shop.domain.TbUserExample;

import com.fan.my.shop.web.admin.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)   //表示整合JUnit4进行测试
@ContextConfiguration(locations = {"classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml","classpath:spring-context.xml"})  //加载spring配置文件
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Test
    public void testSelect(){
        TbUserExample example=new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo("809956159@qq.com");
        criteria.andPasswordEqualTo("5da3693817f8c3597960d070743c0ffb");
        List<TbUser> tbUsers=userServiceImpl.selectByExample(example);
        for (TbUser tbUser:tbUsers){
            System.out.println("********************");
            System.out.println(tbUser.getAddress());
        }
    }
}

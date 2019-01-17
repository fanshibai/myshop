package com.fan.my.shop.web.admin.web.controller;

import com.fan.my.shop.domain.TbUser;
import com.fan.my.shop.domain.TbUserDoMain;
import com.fan.my.shop.domain.TbUserExample;
import com.fan.my.shop.utils.ObjectUtills;
import com.fan.my.shop.web.admin.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


@Controller
@Api(value = "/login", tags = "用户登录Api接口")  //swagger分类标题注解
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = {"login"}, method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户登录", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    public TbUserDoMain login(HttpServletRequest request, @RequestBody TbUser tbUser) {
        System.out.println("loginTo");
        TbUserExample example = ObjectUtills.getExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(tbUser.getEmail());
        criteria.andPasswordEqualTo(tbUser.getPassword());
        List<TbUser> tbUsers=userService.selectByExample(example);
        if (tbUsers.size()>0){
            request.getSession().setAttribute("user",tbUsers.get(0));
            TbUserDoMain tbUserDoMain=new TbUserDoMain();
            tbUserDoMain.setSuccess("1");
                try {
                    BeanUtils.copyProperties(tbUserDoMain,tbUsers.get(0));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return tbUserDoMain;
        }
            TbUserDoMain tbUserDoMain=new TbUserDoMain();
            tbUserDoMain.setSuccess("0");
            return tbUserDoMain;
    }

    @RequestMapping(value = {"","login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"message"}, method = RequestMethod.POST)
    @ResponseBody
    public TbUser message(HttpServletRequest request) {
        TbUser tbUser = (TbUser) request.getSession().getAttribute("user");
        return tbUser;
    }
}

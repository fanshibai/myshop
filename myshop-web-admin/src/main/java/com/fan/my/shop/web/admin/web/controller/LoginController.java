package com.fan.my.shop.web.admin.web.controller;

import com.fan.my.shop.domain.TbUser;
import com.fan.my.shop.web.admin.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@Api(value = "/login", tags = "LoginAPI")  //swagger分类标题注解
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = {"login"}, method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户登录", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    public String login(String loginId,String password,HttpServletRequest request) {
        TbUser  user = userService.selectByLoginID(loginId);
        if (user!=null){
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                return "1";
            }else {
                return "2";
            }
        }
            return "0";
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
    @ApiOperation(value = "获取用户信息", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    public TbUser message(HttpServletRequest request) {
        TbUser tbUser = (TbUser) request.getSession().getAttribute("user");
        return tbUser;
    }

    @GetMapping(value = "salt")
    @ResponseBody
    public String salt(String loginId) {
        TbUser  user = userService.selectByLoginID(loginId);
        if (user!=null) {
            String salt = user.getSalt();
            System.out.println(salt);
            return salt;
        }
        return null;
    }
    @GetMapping(value = "logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}

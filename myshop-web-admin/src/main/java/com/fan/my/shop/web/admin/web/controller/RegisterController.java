package com.fan.my.shop.web.admin.web.controller;

import com.fan.my.shop.domain.TbUser;
import com.fan.my.shop.domain.TbUserDoMain;
import com.fan.my.shop.utils.ObjectUtils;
import com.fan.my.shop.web.admin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RegisterController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value ="register")
    public String register(){
        return "register";
    }
    @PostMapping(value ="register")
    @ResponseBody
    public TbUserDoMain register(@RequestBody TbUser tbUser){
        System.out.println("********************");
        TbUserDoMain userDoMain= ObjectUtils.getUserDoMain();
            int result = userService.insertSelective(tbUser);
            if (result>0){
                userDoMain.setSuccess("1");
                return userDoMain;
            }
        userDoMain.setSuccess("0");
        return userDoMain;
    }
    @GetMapping(value = "checkUsername")
    @ResponseBody
    public String checkUsername(String username){
        TbUser tbUser=new TbUser();
        tbUser.setUsername(username);
        TbUser  user = userService.selectOne(tbUser);
        if (user==null){
            return "1";
        }
        return "0";
    }
    @GetMapping(value = "checkEmail")
    @ResponseBody
    public String checkEmail(String email){
        TbUser tbUser=new TbUser();
        tbUser.setEmail(email);
        TbUser  user = userService.selectOne(tbUser);
        if (user==null){
            return "2";
        }
        return "3";
    }
    @GetMapping(value = "checkPhone")
    @ResponseBody
    public String checkPhone(String phone){
        TbUser tbUser=new TbUser();
        tbUser.setPhone(phone);
        TbUser  user = userService.selectOne(tbUser);
        if (user==null){
            return "4";
        }
        return "5";
    }
}

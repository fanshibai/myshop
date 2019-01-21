package com.fan.my.shop.web.admin.web.controller;

import com.fan.my.shop.domain.TbUser;
import com.fan.my.shop.domain.TbUserDoMain;
import com.fan.my.shop.domain.TbUserExample;
import com.fan.my.shop.utils.ObjectUtils;
import com.fan.my.shop.web.admin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        TbUserDoMain userDoMain= ObjectUtils.getUserDoMain();
            tbUser.setFlag(0);
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
        TbUserExample example = ObjectUtils.getExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbUser> tbUsers = userService.selectByExample(example);
        if (tbUsers.size()==0){
            return "1";
        }
        return "0";
    }
    @GetMapping(value = "checkEmail")
    @ResponseBody
    public String checkEmail(String email){
        TbUserExample example = ObjectUtils.getExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<TbUser> tbUsers = userService.selectByExample(example);
        if (tbUsers.size()==0){
            return "2";
        }
        return "3";
    }
}

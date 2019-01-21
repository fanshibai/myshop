package com.fan.my.shop.utils;

import com.fan.my.shop.domain.TbUserDoMain;
import com.fan.my.shop.domain.TbUserExample;

public class ObjectUtils {
    public static TbUserExample getExample(){
        TbUserExample example=new TbUserExample();
        return  example;
    }
    public static TbUserDoMain getUserDoMain(){

        return  new TbUserDoMain();
    }
}

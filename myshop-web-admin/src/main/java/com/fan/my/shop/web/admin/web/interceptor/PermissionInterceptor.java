package com.fan.my.shop.web.admin.web.interceptor;

import com.fan.my.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 如果请求来自登录页
        // 判断用户是否登录
        if (modelAndView!=null) {
            if (modelAndView.getViewName().endsWith("login")) {
                TbUser user = (TbUser) httpServletRequest.getSession().getAttribute("user");
                if (user != null) {
                    httpServletResponse.sendRedirect("/index");
                }
            }
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

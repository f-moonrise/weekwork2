package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.net.ResponseCache;
import java.util.List;

/**
 * @author zangye03@gmail.com
 * @date 2020/2/10 23:08
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

//    查看好友
    @RequestMapping("getall.do")
    public ModelAndView getAll(){
        ModelAndView m = new ModelAndView();
        List<Users> li = userService.getAll();
        m.addObject("li",li);
        m.setViewName("list");
        return m;
    }

//    新增好友
    @RequestMapping("add.do")
    public ModelAndView addOne(){
        ModelAndView m = new ModelAndView();
        int i = userService.addOne();
        m.addObject("li",i);
        m.setViewName("home");
        return m;
    }

    //    好友提醒
    @RequestMapping(value = "cc.do")
    public ModelAndView cc(){
        ModelAndView m = new ModelAndView();
        List<Users> i = userService.cc();
        m.addObject("li",i);
        m.setViewName("home");
        return m;
    }

//    用户登录
    @RequestMapping("login.do")
    public ModelAndView login(String username, String password,HttpSession httpSession){
//        ModelAndView m = new ModelAndView();
        Users u = userService.login(username,password);
        httpSession.setAttribute("user",u);
//        m.setViewName("home");
//        return m;
        return cc();
    }

//    @RequestMapping("add.do")
//    public ModelAndView addOne( String username,String password){
//        ModelAndView m = new ModelAndView();
//        ResponseCode i = userService.register(username,password);
//        m.addObject("li",i);
//        m.setViewName("add");
//        return m;
//    }

//    @RequestMapping("login.do")
//    public ModelAndView login(String username,String password){
//        ModelAndView m = new ModelAndView();
//        ResponseCode i = userService.login(username,password);
//        m.addObject("li",i);
//        m.setViewName("home");
//        return m;
//    }

}

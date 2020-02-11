package com.itdr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zangye03@gmail.com
 * @date 2020/2/11 21:22
 */
@Controller
@RequestMapping("/index/")
public class IndexController {

//    跳转到新增好友页面
    @RequestMapping("addview.do")
    public String toAddView(){
        return "add";
    }
}

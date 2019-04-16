package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/16 9:23
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
@RequestMapping("page")
public class PageController {
    /**
     * 跳主界面
     * @return
     */
    @RequestMapping("tomain")
    public String tomain(){
        return "main";
    }
    /**
     * 跳注册界面
     * @return
     */
    @RequestMapping("toreg")
    public String toreg(){
        return "reg";
    }
    /**
     * 跳登陆界面
     * @return
     */
    @RequestMapping("tologin")
    public String tologin(){
        return "login";
    }

}

package com.jk.service;

import com.jk.mapper.UserMapper;

import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/15 19:19
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("select/{id}")
    @ResponseBody
    public User queryById (@PathVariable Integer id){

        return userMapper.queryById(id);
    }
}

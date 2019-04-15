package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/15 19:31
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class UserController {
@Autowired
private UserService userService;
    @PostMapping("queryById")
    public User queryById(Integer id){
  return userService.queryById(id);
    }
}

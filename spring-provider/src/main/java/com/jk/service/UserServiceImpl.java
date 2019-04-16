package com.jk.service;

import com.jk.ConstantConf;
import com.jk.mapper.UserMapper;

import com.jk.model.User;
import com.jk.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

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
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @GetMapping("select/{id}")
    @ResponseBody
    public User queryById (@PathVariable Integer id){

        return userMapper.queryById(id);
    }
    /*
    登陆
     */
    @PostMapping("login")
    @ResponseBody
    public HashMap<String, Object> login(@RequestBody User user){
        HashMap<String,Object> result = new HashMap<>();


        User userInfo= userMapper.findIntoByloginnumber(user.getLoginnumber());
//判断账号是否存在
        if(userInfo==null) {
            result.put("code", 2);
            result.put("msg", "账号不存在");
            return result;
        }

        //判断前台输入的密码和数据库的是否一致
        String password = user.getPassword();
        String md516 = Md5Util.getMd516(password);
        if(!userInfo.getPassword().equals(md516)) {
            result.put("code", 3);
            result.put("msg", "密码错误");
            return result;
        }
//将用户信息保存到redis中
        //session.setAttribute(session.getId(), userInfo);
        Long aLong = redisTemplate.opsForList().leftPush(ConstantConf.USER_LOGIN, userInfo);
        result.put("code", 0);
        result.put("msg", "登陆成功");
        return result;
    }
    /**
     * 注册
     */
    @PostMapping("reg")
    @ResponseBody
    public  Boolean save(@RequestBody User user){
        User userInfo= userMapper.findIntoByloginnumber(user.getLoginnumber());
        if(userInfo!=null){
            return false;
        }else{
            user.setPassword(Md5Util.getMd516(user.getPassword()));
            userMapper.save(user);
            return true;

        }
    }
}

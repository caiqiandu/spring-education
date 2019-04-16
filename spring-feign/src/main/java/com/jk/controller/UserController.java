package com.jk.controller;

import com.jk.ConstantConf;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

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
@Resource
private RedisTemplate<String,Object>redisTemplate;
    @PostMapping("queryById")
    public User queryById(Integer id){
  return userService.queryById(id);
    }

    /**
     * 登陆
     * @param user
     * @param
     * @return
     */
   @PostMapping("login")
   public HashMap<String, Object> login(User user,  HttpServletRequest request){
/*       HashMap<String,Object> result = new HashMap<>();
       HttpSession session = request.getSession();
       String sessionCode = session.getAttribute("imgcode").toString();
//判断验证码是否和session中一致
       if(!imgcode.equals(sessionCode)) {
           result.put("code", 1);
           result.put("msg", "验证码错误");
           return result;
       }*/


       return userService.login(user);
   }
    //注册
    @PostMapping("reg")
    public Boolean reg(User user) {
        try {

            return userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 缓存显示
     */
    @GetMapping("xianshi")
   public User xianshi(){
       List<Object> range = redisTemplate.opsForList().range(ConstantConf.USER_LOGIN, 0, -1);
       User o = (User) range.get(0);
       return  o;
   }
}

package com.jk.service;

import com.jk.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/15 19:58
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class UserServiceHystrix implements UserService {
    @Override
    public User queryById(Integer id) {
        User user = new User();
        user.setName("网络异常");
        return user;
    }

    @Override
    public HashMap<String, Object> login(User user) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("1","网络异常");
        return params;
    }

    @Override
    public Boolean save(User user) {

        return false;
    }
}

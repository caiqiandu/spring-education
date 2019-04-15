package com.jk.service;

import com.jk.model.User;
import org.springframework.stereotype.Component;

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
}

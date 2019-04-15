package com.jk.service;

import com.jk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="spring-provider",fallback =UserServiceHystrix.class )
public interface UserService {
    @GetMapping("select/{id}")
    public User queryById (@PathVariable Integer id);
}

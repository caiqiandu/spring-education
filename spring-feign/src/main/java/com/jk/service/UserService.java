package com.jk.service;

import com.jk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@FeignClient(value="spring-provider",fallback =UserServiceHystrix.class )
public interface UserService {
    @GetMapping("select/{id}")
    public User queryById (@PathVariable Integer id);
  @PostMapping("login")
  public   HashMap<String, Object> login(@RequestBody User user);
@PostMapping("reg")
  public  Boolean save(@RequestBody User user);
}

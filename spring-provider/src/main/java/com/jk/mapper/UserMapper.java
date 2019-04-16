package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //@Select("select * from t_user where id=#{value}")
    User queryById(Integer id);
    @Select("select * from t_user where loginnumber=#{value}")
    User findIntoByloginnumber(String loginnumber);
   @Insert("insert into t_user(name,loginnumber,password) values(#{name},#{loginnumber},#{password})")
    void save(User user);
}

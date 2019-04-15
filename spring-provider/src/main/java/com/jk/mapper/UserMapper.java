package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //@Select("select * from t_user where id=#{value}")
    User queryById(Integer id);
}

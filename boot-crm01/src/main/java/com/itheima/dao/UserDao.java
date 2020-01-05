package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public User findUser(@Param("usercode") String usercode, @Param("password") String password);
}

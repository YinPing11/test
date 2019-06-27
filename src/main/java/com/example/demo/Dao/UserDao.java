package com.example.demo.Dao;

import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface UserDao {
    @Select("select * from user where username=#{user.username} and pass=#{user.pass}")
    public User selectUserByname(@Param("user") User user);


}

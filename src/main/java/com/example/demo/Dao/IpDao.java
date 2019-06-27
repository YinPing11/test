package com.example.demo.Dao;

import com.example.demo.Entity.IpAddr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface IpDao {
    @Select("select count(*) from ip where ipaddr=#{ipaddr} and pkid=#{pkid}")
    int findNumber(String ipaddr, int pkid);
    @Insert("insert into ip(ipaddr,pkid) values (#{ipaddr},#{pkid})")
    int addAddr(String ipaddr,int pkid);
}

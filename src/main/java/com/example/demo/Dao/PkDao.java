package com.example.demo.Dao;

import com.example.demo.Entity.pk;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PkDao {
    @Select("select * from pk")
    List<pk> FindPks();
    @Insert("insert into pk(pkname,pk_personnel,pk_beggintime,pk_overtime) values (#{pkname},#{pk_personnel},#{pk_beggintime},#{pk_overtime})")
    int addPk(String pkname,String pk_personnel,String pk_beggintime,String pk_overtime);
    @Delete("DELETE FROM pk WHERE pkid=#{id}")
    int delePk(int id);
    @Update("UPDATE pk SET pk_state=1 WHERE pkid=#{id}")
    int pkStart(int id);
    @Update("UPDATE pk SET pk_state=2 WHERE pkid=#{id}")
    int pkOver(int id);
    @Update("UPDATE pk SET victory_name=#{name} WHERE pkid=#{id}")
    int setChampion(int id,String name);
    @Select("select pk_personnel from pk where pkid=#{id}")
    String findNamesByid(int id);
}

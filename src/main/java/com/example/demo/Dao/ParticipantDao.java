package com.example.demo.Dao;

import com.example.demo.Entity.Participant;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ParticipantDao {
    @Select("select * from participant")
    List<Participant> FindParticipants();
    @Insert("insert into participant(participant_name,game_production,participant_picture) values (#{name},#{game_production},#{picture})")
    int addParticipant(String name,String game_production,String picture);
    @Delete("DELETE FROM participant WHERE participant_id=#{id}")
    int deleParticipant(int id);
    @Select("select poll from participant where participant_name=#{name}")
    int  findPollByname(String name);
    @Select("select * from participant where participant_name=#{name}")
    Participant  findParticipantByname(String name);
    @Select("select poll from participant")
    List<Integer> findAllPoll();
    @Update("update participant set poll = poll + 1 WHERE participant_name=#{name}")
    int addOnePollByName(String name);
}

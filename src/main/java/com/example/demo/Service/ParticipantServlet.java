package com.example.demo.Service;

import com.example.demo.Dao.ParticipantDao;
import com.example.demo.Dao.PkDao;
import com.example.demo.Entity.Participant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class ParticipantServlet {
    @Resource
    private ParticipantDao participantDao;
    @Resource
    private PkDao pkDao;

    public List<Participant> findAll(){
        return  participantDao.FindParticipants();
    }
    public int addPart(String name,String game_production,String picture){return participantDao.addParticipant(name,game_production,picture);}
    public int delParticipantByid(int id){return participantDao.deleParticipant(id);}
    public List<Integer> findAllPoll(){return participantDao.findAllPoll();}
    public List<Participant> findpaParticipantsBypkid(int pkid){
        String names=pkDao.findNamesByid(pkid);
        String[] sourceStrArray = names.split("，");//分割出来的字符数组
        List<Participant> participantList =new ArrayList<Participant>();
        for (int i = 0; i < sourceStrArray.length; i++) {
            Participant p =participantDao.findParticipantByname(sourceStrArray[i]);
            participantList.add(p);
        }
        return participantList;
    }

    public int addOnePollByName(String name){
       return participantDao.addOnePollByName(name);
    }
}

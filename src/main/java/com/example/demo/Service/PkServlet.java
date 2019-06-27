package com.example.demo.Service;

import com.example.demo.Dao.ParticipantDao;
import com.example.demo.Dao.PkDao;
import com.example.demo.Entity.Participant;
import com.example.demo.Entity.pk;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class PkServlet {
    @Resource
    private PkDao pkDao;
    @Resource
    private ParticipantDao participantDao;
    public List<pk> findAllpk(){
        return  pkDao.FindPks();
    }
    public int addPk(String pkname,String pk_personnel,String pk_beggintime,String pk_overtime){return pkDao.addPk(pkname,pk_personnel,pk_beggintime,pk_overtime);}
    public int delByid(int id){ return pkDao.delePk(id);}
    public int beginPk(int id){return pkDao.pkStart(id);}
    public int overPk(int id){return pkDao.pkOver(id);}

    public String findChampion(int id){
        int Maxpoll=0;
        int xiabia=-1;
        String names=pkDao.findNamesByid(id);
        String[] sourceStrArray = names.split("，");//分割出来的字符数组
        HashMap<Integer,String> champion=new HashMap<Integer, String>();
        for (int i = 0; i < sourceStrArray.length; i++) {
            int poll=participantDao.findPollByname(sourceStrArray[i]);
            if(poll>=Maxpoll){
                Maxpoll=poll;
                xiabia=i;
            }
        }
        champion.put(Maxpoll,sourceStrArray[xiabia]);
        pkDao.setChampion(id,champion.get(Maxpoll));
        return champion.get(Maxpoll);
    }
}

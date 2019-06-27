package com.example.demo.Service;

import com.example.demo.Dao.IpDao;
import com.example.demo.Dao.PkDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IpService {
    @Resource
    IpDao ipDao;
    public int findipaddr(String name,int pkid){
        return ipDao.findNumber(name,pkid);
    }

    public int addAddr(String ipaddr,int pkid){
        return ipDao.addAddr(ipaddr,pkid);
    }
}

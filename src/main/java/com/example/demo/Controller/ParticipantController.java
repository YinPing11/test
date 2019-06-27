package com.example.demo.Controller;

import com.example.demo.Dao.IpDao;
import com.example.demo.Entity.Participant;
import com.example.demo.Entity.Reslut;
import com.example.demo.Service.IpService;
import com.example.demo.Service.ParticipantServlet;
import com.example.demo.until.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ParticipantController {
    @Autowired
    ParticipantServlet participantServlet;
    @Autowired
    IpService ipService;

    @RequestMapping("/participantshow")
    public ModelAndView ParticipantShowshow(){
        ModelAndView mv=new ModelAndView("vote/ParticipantShow");
        return mv;
    }
    @RequestMapping("/participantadd")
    public ModelAndView ParticipantAdd(){
        ModelAndView mv=new ModelAndView("vote/addparticipant");
        return mv;
    }
    @GetMapping("/findallp")
    @ResponseBody
    public List<Participant> FindAllParticipant(){
        List<Participant> p=participantServlet.findAll();
        return participantServlet.findAll();
    }


    @PostMapping("/delparticipant")
    @ResponseBody
    public Reslut deleteByid(int id){
        int a=participantServlet.delParticipantByid(id);
        Reslut re=new Reslut();
        if(a>0){
            re.setI(1);
            re.setContent("删除成功");
        }else {
            re.setI(-1);
            re.setContent("删除失败");
        }
        return re;
    }
    @ResponseBody
    @GetMapping("/findpoll")
    public List<Integer> findPoll(){
        return participantServlet.findAllPoll();
    }
    @PostMapping("/addPoll")
    @ResponseBody
    public Reslut addPollOne(String name,int pkid, HttpServletRequest request){
        String idadrr=IpUtil.getIpAddr(request);
        Reslut rs=new Reslut();
        int num=ipService.findipaddr(idadrr,pkid);
        if (num>0){
            rs.setI(0);
            rs.setContent("你已经参与过投票了");
            return rs;
        }
        int q=ipService.addAddr(idadrr,pkid);
        if(q>0){
            int i=participantServlet.addOnePollByName(name);
            if(i>0){
                rs.setI(1);
                rs.setContent("投票成功");
                return rs;
            }else {
                rs.setI(0);
                rs.setContent("投票失败");
            }
        }else {
            rs.setI(0);
            rs.setContent("发生未知错误请稍后重试");
        }

        return rs;
    }

}

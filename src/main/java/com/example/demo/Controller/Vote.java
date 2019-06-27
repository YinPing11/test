package com.example.demo.Controller;

import com.example.demo.Entity.Participant;
import com.example.demo.Service.ParticipantServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Vote {
    @Autowired
    ParticipantServlet participantServlet;
    @GetMapping("/tovote")
    public ModelAndView ToYote(){
        ModelAndView mv=new ModelAndView("voter/toupiaonew");
        return mv;
    }

    @GetMapping("/GetParticipants")
    @ResponseBody
    public List<Participant> getParticipantsByPkid(int pkid){
        List<Participant> list =participantServlet.findpaParticipantsBypkid(pkid);
        return list;
    }
}

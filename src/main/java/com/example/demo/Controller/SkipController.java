package com.example.demo.Controller;

import com.example.demo.Entity.Participant;
import com.example.demo.Service.ParticipantServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SkipController {
    @Autowired
    ParticipantServlet participantServlet;

    @RequestMapping("/returnSkip")
    public ModelAndView returnSkip(){
        ModelAndView mv=new ModelAndView("voter/skip");
        return mv;
    }
    @PostMapping("/getVoteByid")
    @ResponseBody
    public List<Participant> getVoteByPkid(int id){
        return participantServlet.findpaParticipantsBypkid(id);
    }
}

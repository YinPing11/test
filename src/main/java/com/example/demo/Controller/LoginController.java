package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.LoginService;
import com.example.demo.until.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv=new ModelAndView("login/login");
        return mv;
    }
    @RequestMapping("/qqq")
    public ModelAndView logi5n(){
        ModelAndView mv=new ModelAndView("vote/sss");
        return mv;
    }
    @PostMapping("/login_sumbit")
    public ModelAndView login_sumbit(HttpServletRequest request){
        String name=request.getParameter("name");
        String pass=MD5.MD5Encode(request.getParameter("pass"),"utf-8");
        System.out.println(pass);
        User user=new User();
        user.setPass(pass);
        user.setUsername(name);
        User u=loginService.login(user);
        if (u!=null){
            ModelAndView mv=new ModelAndView("index");
            return mv;
        }else {
            ModelAndView mv=new ModelAndView("login/login");
            return mv;
        }
    }

    @RequestMapping("/sss")
    public ModelAndView ss(){
        ModelAndView mv=new ModelAndView("index.html");
        return mv;
    }
    @RequestMapping("/vote")
    public ModelAndView sss(){
        ModelAndView mv=new ModelAndView("vote/voteshow.html");
        return mv;
    }
    @RequestMapping("/voteqq")
    public ModelAndView ssqqs(){
        ModelAndView mv=new ModelAndView("vote/ParticipantShow.html");
        return mv;
    }
}

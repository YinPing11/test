package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv=new ModelAndView("index.html");
        return mv;
    }
}

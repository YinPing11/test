package com.example.demo.Controller;


import com.example.demo.Entity.Reslut;
import com.example.demo.Entity.pk;
import com.example.demo.Service.PkServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PkController {
    @Autowired
    private PkServlet pkServlet;

    @RequestMapping("/showpk")
    public ModelAndView pkShowshow(){
        ModelAndView mv=new ModelAndView("vote/voteshow");
        return mv;
    }
    @RequestMapping("/addpk")
    public ModelAndView pkAdd(){
        ModelAndView mv=new ModelAndView("vote/addpk");
        return mv;
    }

    @ResponseBody
    @PostMapping("/addpk_sumbit")
    public Reslut addpk_sumbit(pk p){
        Reslut reslut=new Reslut();
        int i=pkServlet.addPk(p.getPkname(),p.getPk_personnel(),p.getPk_beggintime(),p.getPk_overtime());
        if(i>0){
            reslut.setI(1);
            reslut.setContent("添加成功");
        }else {
            reslut.setI(-1);
            reslut.setContent("添加失败");
        }
        return  reslut;
    }

    @GetMapping("/findallpk")
    @ResponseBody
    public List<pk> FindAllParticipant(){
        System.out.println(pkServlet.findAllpk().get(1).getPk_beggintime());
        return pkServlet.findAllpk();
    }

    @PostMapping("/delpk")
    @ResponseBody
    public Reslut deleteByid(int id){
        int a=pkServlet.delByid(id);
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

    @PostMapping("/begin")
    @ResponseBody
    public Reslut StartPk(int id){
        int a=pkServlet.beginPk(id);
        Reslut re=new Reslut();
        if(a>0){
            re.setI(1);
            re.setContent("投票PK开始");
        }else {
            re.setI(-1);
            re.setContent("开始投票PK失败");
        }
        return re;
    }

    @PostMapping("/over")
    @ResponseBody
    public Reslut OverPk(int id){
        int a=pkServlet.overPk(id);
        Reslut re=new Reslut();
        if(a>0){
            re.setI(1);
            re.setContent("结束投票PK");
        }else {
            re.setI(-1);
            re.setContent("结束投票PK失败");
        }
        return re;
    }

    @PostMapping("/findChampion")
    @ResponseBody
    public String findChampion(int id){
        String champion=pkServlet.findChampion(id);
        return champion;
    }
}

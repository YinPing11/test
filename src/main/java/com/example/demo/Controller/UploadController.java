package com.example.demo.Controller;

import com.example.demo.until.Getnumber;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.example.demo.Config.UploadUtils;
import com.example.demo.Entity.Reslut;
import com.example.demo.Service.ParticipantServlet;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

@Controller
public class UploadController {
    @Autowired
    ParticipantServlet participantServlet;

    // 因为uploadPage.jsp 在WEB-INF下，不能直接从浏览器访问，所以要在这里加一个uploadPage跳转，这样就可以通过
    @RequestMapping("/shangchuan")
    public ModelAndView uploadPage() {
        ModelAndView mv=new ModelAndView("vote/shangchuan");
        return mv;   //过度跳转页
    }

    @ResponseBody
    @PostMapping("/upload")
    public Reslut upload(HttpServletRequest request) throws UnsupportedEncodingException, FileUploadException {
        String productName = null;
        String productDes = null;
        String filename = null;
        DiskFileItemFactory dff = new DiskFileItemFactory();
        ServletFileUpload fu = new ServletFileUpload(dff);
        Reslut msg = new Reslut();

        List li = fu.parseRequest(request);
        System.out.println(li.size());
        Iterator iter = li.iterator();

        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (item.isFormField()) {  //此处是判断非文件域，即不是<inputtype="file"/>的标签
                String name = item.getFieldName(); //获取form表单中name的id
                if ("participant_name".equals(name))
                    productName = item.getString("utf-8"); //item是指定id的value值，此处用      item.getString("utf-8")是把item用utf-8解析，根据你的需要可以用其他的，如：gbk；
                else if ("game_production".equals(name))
                    productDes = item.getString("utf-8");
            } else {
                // 拿到文件名
                filename = System.currentTimeMillis()+".png";

                // 存放上传图片的文件夹
                File fileDir = UploadUtils.getImgDirFile();
                // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
                System.out.println(fileDir.getAbsolutePath());

                try {
                    // 构建真实的文件路径
                    File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
                    System.out.println(newFile.getAbsolutePath());

                    // 上传图片到 -》 “绝对路径”
                    item.write(newFile);

                    msg.setContent("上传成功!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
            if (participantServlet.addPart(productName, productDes, filename) > 0) {
                msg.setI(1);
                msg.setContent("人员添加成功");
            }
            return msg;
        }
}

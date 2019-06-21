package com.hb.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hb.pojo.FileEntity;
import com.hb.util.FileUploadTool;

@Controller
@RequestMapping("/uploadflv")
public class UploadController {
    @RequestMapping(value = "/upload", method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
            HttpServletRequest request, ModelMap map) {
        String message = "";
        FileEntity entity = new FileEntity();
        System.out.println("request:+"+request);
        FileUploadTool fileUploadTool = new FileUploadTool();
        try {
            entity = fileUploadTool.createFile(multipartFile, request);
            if (entity != null) {
//                service.saveFile(entity);
                message = "上传成功";
                map.put("entity", entity);
                System.out.println("上传成功");
                map.put("result", message);
            } else {
                message = "上传失败";
                System.out.println("上传失败");
                map.put("result", message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
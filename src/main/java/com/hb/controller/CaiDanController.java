package com.hb.controller;

import com.hb.pojo.CaiDan;
import com.hb.service.CaiDanService;
import com.hb.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/caidan")
public class CaiDanController {

    @Autowired
    private CaiDanService caiDanService;

    @RequestMapping("/diancan")
    public String doDianCan(){
        return "diancan";
    }

    @RequestMapping("/query")
    @ResponseBody
    public SysResult doQueryCaiPin(Integer lei){
        try {
            List<CaiDan> list = caiDanService.findCaiDanByLeiXing(lei);
            return SysResult.ok(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return SysResult.fail();
    }

    @RequestMapping("/tebie")
    @ResponseBody
    public SysResult doTebieCaiPin(String par){
        try {
            List<CaiDan> list = caiDanService.findCaiDanByTeBie(par);
            return SysResult.ok(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return SysResult.fail();
    }

}

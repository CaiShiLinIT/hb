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

    /**
     * 注入菜单业务接口实现类
     */
    @Autowired
    private CaiDanService caiDanService;

    /**
     * 显示页面
     * @return 返回页面
     */
    @RequestMapping("/diancan")
    public String doDianCan(){
        return "diancan";
    }

    /**
     * 查询商品固有属性
     * @param lei 类别 1->菜 2->主食 3->汤类 4->饮料 5->甜品小吃
     * @return 返回SysResult
     */
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

    /**
     * 查询特别属性的商品 如折扣、推荐、新品
     * @param par 传入字段
     * @return 返回SysResult
     */
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

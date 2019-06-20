package com.hb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.common.SysResult;
import com.hb.service.ManageService;
import com.hb.vo.DingDanXinXiManage2VO;

@Controller
public class ManageController {
	@Autowired
	private ManageService manageService;
	
	@RequestMapping("/{module}")
	public String findAll(@PathVariable String module) {
		return module;
	}
	//  /manage/booking/msg?bookingDate=2019-05-30&selectTime=2
	@RequestMapping("/manage/booking/msg")
	@ResponseBody
	public SysResult findAll(String bookingDate,Integer selectTime) {
		System.out.println("进入controller层了");
		DingDanXinXiManage2VO findAll = manageService.findAll(bookingDate,selectTime);
		System.out.println("最终查询结果:"+findAll);
		//返回数据
		return SysResult.ok(findAll);//逻辑名称 拼接前后缀
	}
}

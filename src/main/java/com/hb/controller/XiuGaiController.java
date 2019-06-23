package com.hb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.common.SysResult;
import com.hb.pojo.ShangJiaPojo;
import com.hb.service.XiuGaiService;

@Controller
public class XiuGaiController {
	@Autowired
	private XiuGaiService xiuGaiService;
	
	@RequestMapping("findD")
	@ResponseBody
	public SysResult findD() {
		ShangJiaPojo findD = xiuGaiService.findD();
		return SysResult.ok(findD);
	}
}

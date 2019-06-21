package com.hb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.pojo.CaiDanPojo;
import com.hb.service.SouSuoService;
import com.hb.vo.SysResult;

@Controller
@RequestMapping("sou")
public class SouSuoController {
	@Autowired
	private SouSuoService souSuoService;
	//执行搜索方法
	@RequestMapping("/doSouSuo")
	@ResponseBody
	public SysResult SouSuo(String name) {
		try {
			//通过前端传的搜索信息搜索包含搜索信息的菜单
			List<CaiDanPojo> list=souSuoService.findCaiDan(name);
			System.err.println(list);
			return SysResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.fail();
	}
	
}

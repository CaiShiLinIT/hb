package com.hb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.common.SysResult;
import com.hb.pojo.ShowyhplPojo;
import com.hb.service.ShowyhplService;

@Controller
public class ShowyhplController {
	@Autowired
	private ShowyhplService showyhplService;
	
	@RequestMapping("/showpinglun")
	@ResponseBody
	public SysResult showyhpl(Integer caiDanId) {
		try {
			List<ShowyhplPojo> showyhpl6 = showyhplService.showyhpl(caiDanId);
			System.out.println(showyhpl6);
			return SysResult.ok(showyhpl6);
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.fail();
		}
	}

}

package com.hb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;

	@RequestMapping("/findAll")
	public String findAll() {
		//List<User> userList = testService.findAll();
		return "index";//逻辑名称 拼接前后缀
	}
}

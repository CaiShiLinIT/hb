package com.hb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CkplayerController {
	@RequestMapping("/indexx")
	public String index() {
		return "indexx";
	}
	@RequestMapping("/index2")
	public String index2() {
		return "NewFile";
	}
	@RequestMapping("/index3")
	public String index3() {
		return "dm";
	}
}

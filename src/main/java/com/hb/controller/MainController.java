package com.hb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
	@RequestMapping("/{module}")
	public String findAll(@PathVariable String module) {
		return module;
	}
}

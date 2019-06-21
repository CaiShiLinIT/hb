package com.hb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.service.MapService;


@Controller
public class MapController {
	@Autowired
	private MapService mapService;
	@RequestMapping("/dili/{city}/{address}")
	@ResponseBody
	public String diliFind(@PathVariable String city,@PathVariable String address) {
		System.out.println(city+address);
		String status=mapService.siliFind(city,address);
		return status;
	}
	@RequestMapping("/luji/{city}/{address}")	
	@ResponseBody
	public String lujiFind(@PathVariable String city,@PathVariable String address ) {
		String status=mapService.lujiFind(city,address);
		return status;
	}
	@RequestMapping("/map")
	public String Map(Model model) {
		model.addAttribute("name", "北京");
		model.addAttribute("names", "北京珠宝首饰研修学院");
		return "map";
	}
	@RequestMapping("/maplujing")
	@ResponseBody
	public Integer maplujing(String distance,String ts) {
		if (!StringUtils.isEmpty(distance)&&!StringUtils.isEmpty(ts)) {
			System.out.println(distance+"公里"+ts+"分");
			return 1;
		}
//		if (distance!=null&&ts!=null) {
//			System.out.println(distance+"公里"+ts+"分");
//			return 1
//		}
		return 0;
	}
}

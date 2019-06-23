package com.hb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.pojo.PingLunPojo;
import com.hb.service.PingLunService;
import com.hb.vo.SysResult;

@Controller
@RequestMapping("huifu/")
public class HuiFuController {
	@Autowired
	private PingLunService pingLunService;
	
	@RequestMapping("inseaseHuiFu")
	public SysResult inseaseHuiFu(String pingLun,String inf,String userName) {
		System.err.println(pingLun+","+inf+","+userName);
		String [] in=inf.split(",");
		int caiID=Integer.valueOf(in[0]);
		int fuJiID=Integer.valueOf(in[1]);
		int pid=Integer.valueOf(in[2]);
		System.out.println(caiID);
		System.out.println(fuJiID);
		System.out.println(pid);
		PingLunPojo pingLunPojo=new PingLunPojo();
		pingLunPojo.setPingLun(pingLun);
		pingLunPojo.setYongHuMing(userName);
		pingLunPojo.setCaiDanID(caiID);
		pingLunPojo.setFuJiID(fuJiID);
		pingLunPojo.setPid(pid);
		pingLunPojo.setPingFen(11);
		
		int row2=pingLunService.addPL(pingLunPojo);
		
		return  SysResult.ok();
	}

}

package com.hb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.pojo.PingLunPojo;
import com.hb.service.PingLunService;
import com.hb.vo.SysResult;


@Controller
@RequestMapping("pinglun/")
public class PingLunController {
	@Autowired
	private PingLunService pingLunService;
	
	@RequestMapping("ineasePingLun")
	@ResponseBody
	public SysResult inceasePingLun(String pingFen,String pingLun, String caiDanId,String userName) {
		//System.err.println(pingFen+","+pingLun+","+caiDanId+","+userName);
		
		PingLunPojo pingLunPojo=new PingLunPojo();
		pingLunPojo.setPingFen(Integer.valueOf(pingFen));
		pingLunPojo.setPingLun(pingLun);
		pingLunPojo.setFuJiID(0);
		pingLunPojo.setYongHuMing(userName);
		pingLunPojo.setPid(0);
		pingLunPojo.setCaiDanID(Integer.valueOf(caiDanId));
		
		List<Integer> findAllFenShu=pingLunService.findAllFenShuByCaiDanId(caiDanId);
		//数据库中菜品之前的分数和
		double all=0;
		//System.err.println(findAllFenShu.size());
		if(findAllFenShu.size()>=1) {
			for (int i = 0; i < findAllFenShu.size(); i++) {
				all +=findAllFenShu.get(i);
			}
		}
		//取出之前的分数之和加上本次评价的分数除以之前评价次数加1
		double pingfen=(all+Integer.valueOf(pingFen))/(findAllFenShu.size()+1);
		//保留菜品评分一位小数
		Double zonghepingfen = Double.valueOf(String.format("%.1f", pingfen));
		//修改菜品评分
		int row = pingLunService.updatePingfen(caiDanId,zonghepingfen);
		//System.out.println(row);
		//添加评论到菜品评价表
		int row2=pingLunService.addPL(pingLunPojo);
		//System.out.println(row2);
		return SysResult.ok();
	} 
	
	
	
}



package com.hb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.mapper.XiangQingMapper;
import com.hb.pojo.CaiDanPojo;
import com.hb.service.XiangQingService;

@Service
public class XiangQingServiceImpl implements XiangQingService{

	@Autowired
	private XiangQingMapper xiangQingMapper;
	@Override
	public CaiDanPojo findxiangqing(Integer caiDanId) {
		CaiDanPojo paiMing = xiangQingMapper.findxiangqing(caiDanId);
		System.out.println("哈哈哈呵呵");
		System.out.println("哈哈哈呵呵");
		return paiMing;
	}

}

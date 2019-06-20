package com.hb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.mapper.DianCaiMapper;
import com.hb.pojo.CaiDanPojo;

@Service
public class DianCanServiceImpl implements DianCanService{

	@Autowired
	private DianCaiMapper dianCaiMapper;
	
	@Override
	public List<CaiDanPojo> findPaiMing() {
		return dianCaiMapper.findPaiMing();
	}
 
}

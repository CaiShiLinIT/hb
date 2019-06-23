package com.hb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.mapper.PingLunMapper;
import com.hb.pojo.PingLunPojo;
import com.hb.service.PingLunService;

@Service
public class PingLunServiceImpl implements PingLunService{
	@Autowired
	private PingLunMapper pingLunMapper;

	@Override
	public List<Integer> findAllFenShuByCaiDanId(String caiDanId) {
		// TODO Auto-generated method stub
		return pingLunMapper.findAllFenShuByCaiDanId(caiDanId);
	}

	@Override
	public int updatePingfen(String caiDanId, double zonghepingfen) {
		
		return pingLunMapper.updatePingfen(caiDanId,zonghepingfen);
	}

	@Override
	public int addPL(PingLunPojo pingLunPojo) {
		
		return pingLunMapper.addPL(pingLunPojo);
	}




	
	

}

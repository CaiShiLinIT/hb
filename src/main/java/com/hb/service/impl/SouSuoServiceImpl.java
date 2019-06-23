package com.hb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.mapper.SouSuoMapper;
import com.hb.pojo.CaiDanPojo;
import com.hb.service.SouSuoService;
@Service
public class SouSuoServiceImpl implements SouSuoService{
	@Autowired
	private  SouSuoMapper souSuoMapper;
	@Override
	public List<CaiDanPojo> findCaiDan(String name) {
		System.err.println(name);
		return souSuoMapper.findCaiDan(name);
	}
	
}

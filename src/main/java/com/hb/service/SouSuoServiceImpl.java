package com.hb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.mapper.SouSuoMapper;
import com.hb.pojo.CaiDanPojo;
@Service
public class SouSuoServiceImpl implements SouSuoService{
	@Autowired
	private  SouSuoMapper souSuoMapper;
	@Override
	public List<CaiDanPojo> findCaiDan(String name) {
		return souSuoMapper.findCaiDan(name);
	}
	
}

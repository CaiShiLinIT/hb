package com.hb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.mapper.LeiMapper;
import com.hb.pojo.CaiDanPojo;
import com.hb.service.LeiService;

@Service
public class LeiServiceImpl implements LeiService {

	@Autowired
	private LeiMapper leiMapper;
	@Override
	public List<CaiDanPojo> findLei(Integer caiPinLeiXing) {
		return leiMapper.findLei(caiPinLeiXing);
	}

}

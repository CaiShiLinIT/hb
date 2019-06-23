package com.hb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.mapper.ShowyhplMapper;
import com.hb.pojo.ShowyhplPojo;
import com.hb.service.ShowyhplService;
@Service
public class ShowyhplServiceImpl implements ShowyhplService{
	@Autowired
	private ShowyhplMapper showyhplMapper;

	@Override
	public List<ShowyhplPojo> showyhpl(Integer caiDanId) {
		List<ShowyhplPojo> pl = showyhplMapper.showyhpl(caiDanId);
		System.out.println(pl);
		return pl;
	}

}

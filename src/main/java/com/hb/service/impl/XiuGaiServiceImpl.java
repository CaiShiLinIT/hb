package com.hb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.mapper.XiuGaiMapper;
import com.hb.pojo.ShangJiaPojo;
import com.hb.service.XiuGaiService;

@Service
public class XiuGaiServiceImpl implements XiuGaiService {
	@Autowired
	private XiuGaiMapper xiuGaiMapper;
	@Override
	public ShangJiaPojo findD() {
		return xiuGaiMapper.findD();
	}

}

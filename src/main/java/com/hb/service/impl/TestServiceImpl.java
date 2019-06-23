package com.hb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.mapper.TestMapper;
import com.hb.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestMapper testMapper;

	
}

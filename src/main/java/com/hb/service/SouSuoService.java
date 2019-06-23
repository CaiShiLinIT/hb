package com.hb.service;

import java.util.List;

import com.hb.pojo.CaiDanPojo;

public interface SouSuoService {

	List<CaiDanPojo> findCaiDan(String name);

}

package com.hb.service;

import java.util.List;

import com.hb.pojo.CaiDanPojo;

public interface LeiService {
	List<CaiDanPojo> findLei(Integer caiPinLeiXing);
}

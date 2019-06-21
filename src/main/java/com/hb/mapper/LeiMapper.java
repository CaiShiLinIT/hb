package com.hb.mapper;

import java.util.List;

import com.hb.pojo.CaiDanPojo;

public interface LeiMapper {
	List<CaiDanPojo> findLei(Integer caiPinLeiXing);
}

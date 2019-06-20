package com.hb.service;

import java.util.List;

import com.hb.pojo.CaiDanPojo;

public interface DianCanService {
	/**
	 * 根据销量显示当前菜品排行前5的菜品信息
	 * @return
	 */
	List<CaiDanPojo> findPaiMing();
}

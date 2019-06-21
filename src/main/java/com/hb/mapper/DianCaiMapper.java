package com.hb.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hb.pojo.CaiDanPojo;

public interface DianCaiMapper extends BaseMapper<CaiDanPojo>{
	//根据销量显示当前菜品排行前5的菜品信息
	List<CaiDanPojo> findPaiMing();
}

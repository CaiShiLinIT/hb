package com.hb.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hb.pojo.CaiDanPojo;

public interface XiangQingMapper extends BaseMapper<CaiDanPojo>{

	CaiDanPojo findxiangqing(Integer caiDanId);
	
}

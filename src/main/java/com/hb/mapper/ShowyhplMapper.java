package com.hb.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hb.pojo.ShowyhplPojo;

public interface ShowyhplMapper extends BaseMapper<ShowyhplPojo>{
	
	List<ShowyhplPojo> showyhpl(Integer caiDanId);

}

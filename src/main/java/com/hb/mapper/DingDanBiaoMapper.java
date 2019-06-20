package com.hb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hb.pojo.DingDanBiao;

public interface DingDanBiaoMapper extends BaseMapper<DingDanBiao> {
	@Select("select * from dingdanbiao")
	List<DingDanBiao> findList();

}

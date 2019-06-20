package com.hb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hb.pojo.DingDanCaiDanBiao;
import com.hb.vo.DingDanCaiDanVO;

public interface DingDanCaiDanBiaoMapper extends BaseMapper<DingDanCaiDanBiao> {
	@Select("select count(*) riXiaoLiang,caiPinID from dingdancaidanbiao where dingDanID=#{dingDanID} group by caiPinID")
	List<DingDanCaiDanVO> findRiXiaoLiang(Integer dingDanID);

}

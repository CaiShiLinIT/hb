package com.hb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hb.pojo.PingLunPojo;

public interface PingLunMapper {
	
	List<Integer> findAllFenShuByCaiDanId(@Param("caiDanId") String caiDanId);

	int updatePingfen(@Param("caiDanId")String caiDanId, 
			@Param("zonghepingfen")double zonghepingfen);

	int addPL(PingLunPojo pingLunPojo);
	
}

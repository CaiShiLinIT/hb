package com.hb.service;

import java.util.List;

import com.hb.pojo.PingLunPojo;

public interface PingLunService {

	List<Integer> findAllFenShuByCaiDanId(String caiDanId);

	int updatePingfen(String caiDanId, double zonghepingfen);

	int addPL(PingLunPojo pingLunPojo);

}

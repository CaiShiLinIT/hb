package com.hb.service;

import com.hb.pojo.CaiDan;

import java.util.List;

public interface CaiDanService {
    List<CaiDan> findCaiDanByLeiXing(Integer lei);

    List<CaiDan> findCaiDanByTeBie(String par);
}

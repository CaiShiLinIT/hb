package com.hb.service;

import com.hb.pojo.CaiDan;

import java.util.List;

public interface CaiDanService {
    /**
     * 根据类别查询
     * @param lei
     * @return
     */
    List<CaiDan> findCaiDanByLeiXing(Integer lei);

    /**
     * 根据特殊属性查询
     * @param par
     * @return
     */
    List<CaiDan> findCaiDanByTeBie(String par);
}

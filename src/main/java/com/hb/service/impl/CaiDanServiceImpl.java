package com.hb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hb.anno.Redis_Cache;
import com.hb.mapper.CaiDanMapper;
import com.hb.pojo.CaiDan;
import com.hb.service.CaiDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CaiDanServiceImpl implements CaiDanService {
    @Autowired
    private CaiDanMapper caiDanMapper;

    @Redis_Cache("caipin")
    @Override
    public List<CaiDan> findCaiDanByLeiXing(Integer lei) {
        List<CaiDan> list = caiDanMapper.selectList(
                new QueryWrapper<CaiDan>().eq("caiPinLeiXing", lei));
        return list;
    }

    @Redis_Cache("teShuCaiPin")
    @Override
    public List<CaiDan> findCaiDanByTeBie(String par) {
        List<CaiDan> list = caiDanMapper.selectList(
                new QueryWrapper<CaiDan>().eq(par, 1));
        return list;
    }
}

package com.hb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hb.anno.Redis_Cache;
import com.hb.mapper.CaiDanMapper;
import com.hb.pojo.CaiDan;
import com.hb.service.CaiDanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaiDanServiceImpl implements CaiDanService {
    @Autowired
    private CaiDanMapper caiDanMapper;

    /**
     * @param lei 类别
     * @return List<CaiDan>
     */
    @Redis_Cache("caipin") //此注解使用AOP从Redis存取数据
    @Override
    public List<CaiDan> findCaiDanByLeiXing(Integer lei) {
        List<CaiDan> list = caiDanMapper.selectList(
                new QueryWrapper<CaiDan>().eq("caiPinLeiXing", lei));
        return list;
    }

    /**
     *
     * @param par 字段
     * @return List<CaiDan>
     */
    @Redis_Cache("teShuCaiPin")  //此注解使用AOP从Redis存取数据
    @Override
    public List<CaiDan> findCaiDanByTeBie(String par) {
        List<CaiDan> list = caiDanMapper.selectList(
                new QueryWrapper<CaiDan>().eq(par, 1));
        System.out.println("111");
        return list;
    }
}

package com.hb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hb.mapper.CaiDanBiaoMapper;
import com.hb.mapper.DingDanBiaoMapper;
import com.hb.mapper.DingDanCaiDanBiaoMapper;
import com.hb.pojo.CaiDanBiao;
import com.hb.pojo.DingDanBiao;
import com.hb.pojo.DingDanCaiDanBiao;
import com.hb.service.ManageService;
import com.hb.vo.DingDanCaiDanVO;
import com.hb.vo.DingDanXinXiManage2VO;
import com.hb.vo.DingDanXinXiManageVO;

@Service
public class ManageServiceImpl implements ManageService{
	@Autowired
	private DingDanBiaoMapper dingDanBiaoMapper;
	@Autowired
	private DingDanCaiDanBiaoMapper dingDanCaiDanBiaoMapper;
	@Autowired
	private CaiDanBiaoMapper caiDanBiaoMapper;
	//List<DingDanXinXiManageVO> userList

	@Override
	public DingDanXinXiManage2VO findAll(String bookingDate,Integer selectTime) {
		//取出订单表中数据
		List<DingDanBiao> allList = dingDanBiaoMapper.findList();
		System.out.println("取出订单表中所有数据:"+allList);
		//新建返回的list(封装页面需要的菜名,日销量,收入)集合
		List<DingDanXinXiManageVO> list = new ArrayList<>();
		//创建总价格
		Double allCount=0.0;
		//遍历循环,拿到每一个订单表pojo对象
		for (DingDanBiao dingDanBiao : allList) {
			//将时间戳类型转换为string
			String xiaDanShiJian=dingDanBiao.getXiaDanShiJian().toString();
			//截成年月日格式2019-06-19
			String newXiaDanShiJian = xiaDanShiJian.substring(0,10);
			System.out.println(newXiaDanShiJian);
			//判断是否符合要求
			if(newXiaDanShiJian.equals(bookingDate)) {
				if(dingDanBiao.getZaoWuWan()==selectTime) {
					Integer dingDanID = dingDanBiao.getDingDanID();
					System.out.println("dingDanID订单id:"+dingDanID);
					//符合要求的对象进行查询vo对象(菜单id,菜名,日销量,单品收入)
					List<DingDanCaiDanVO> dingDanCaiDanVO=dingDanCaiDanBiaoMapper.findRiXiaoLiang(dingDanID);
					System.out.println("dingDanCaiDanVO:"+dingDanCaiDanVO);
					for (DingDanCaiDanVO dingDanCaiD : dingDanCaiDanVO) {
						CaiDanBiao caiDan = caiDanBiaoMapper.selectById(dingDanCaiD.getCaiPinID());
						System.out.println("caiDan:"+caiDan);
						String caiMing=caiDan.getCaiMing();//终于获取到菜名
						Integer riXiaoLiang=dingDanCaiD.getRiXiaoLiang();//获取到日销量
						Double danPinShouRu=riXiaoLiang*caiDan.getYuanJiaGe();
						allCount+=danPinShouRu;
						System.out.println("allCount:"+allCount);
						DingDanXinXiManageVO dingDanXinXiManageVO = new DingDanXinXiManageVO();
						dingDanXinXiManageVO.setCaiMing(caiMing)
											.setDanPinShouRu(danPinShouRu)
											.setRiXiaoLiang(riXiaoLiang);
						System.out.println("dingDanXinXiManageVO:"+dingDanXinXiManageVO);
						list.add(dingDanXinXiManageVO);
					}
				}
			}
		}
		DingDanXinXiManage2VO dingDanXinXiManage2VO = new DingDanXinXiManage2VO();
		dingDanXinXiManage2VO.setAllCount(allCount);
		dingDanXinXiManage2VO.setLists(list);
		return dingDanXinXiManage2VO;
		
	}
	
}

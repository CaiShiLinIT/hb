package com.hb.service;

import java.util.Date;

import com.hb.vo.DingDanXinXiManage2VO;
import com.hb.vo.DingDanXinXiManageVO;

public interface ManageService {

	DingDanXinXiManage2VO findAll(String bookingDate,Integer selectTime);

}

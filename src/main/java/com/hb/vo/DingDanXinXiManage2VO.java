package com.hb.vo;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
/**
 * 订单信息管理第二层vo
 */
public class DingDanXinXiManage2VO {
	private List<DingDanXinXiManageVO> lists;
	private Double allCount;
}

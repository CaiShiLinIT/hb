package com.hb.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
/**
 * 订单信息管理第一层vo
 */
public class DingDanXinXiManageVO {
	private String caiMing;
	private Integer riXiaoLiang;
	private Double danPinShouRu;
}

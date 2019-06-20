package com.hb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@TableName("caidanbiao")
public class CaiDanBiao implements Serializable{

	private static final long serialVersionUID = -3711230375606140601L;
	@TableId(type=IdType.AUTO)
	private Integer caiDanID;
	private String caiMing;
	private Double yuanJiaGe;
	private Double youHuiJiaGe;
	private String caiPinMiaoShu;
	private Integer caiPinLeiXing;
	private Integer yueXiaoLiang;
	private Double pingFen;
	private String caiPinTuPian;
	private Integer tuiJian;
	private Integer zheKou;
	private Integer xinPin;
}

package com.hb.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@TableName("dingdanbiao")
public class DingDanBiao implements Serializable{
	
	private static final long serialVersionUID = 7628995056118756156L;
	@TableId(type=IdType.AUTO)
	private Integer dingDanID;
	private Integer yongHuID;
	private Double peiSongFei;
	private String teShuYaoQiu;
	private Timestamp xiaDanShiJian;
	private String songHuoShiJian;
	private Double zongJiaGe;
	private Integer zaoWuWan;
}

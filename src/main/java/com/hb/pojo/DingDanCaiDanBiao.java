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
@TableName("dingdancaidanbiao")
public class DingDanCaiDanBiao implements Serializable{
	private static final long serialVersionUID = 1649885844138740985L;
	@TableId(type=IdType.AUTO)
	private Integer dingDanCaiDanID;
	private Integer caiPinID;
	private Integer dingDanID;
}

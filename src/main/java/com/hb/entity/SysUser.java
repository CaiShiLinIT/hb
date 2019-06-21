package com.hb.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@TableName("yonghubiao")
public class SysUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1187637640796474205L;
	@TableId(type=IdType.AUTO)
	private Integer yongHuID;
	private String yongHuMing;
	private String miMa;
	private String diZhi;
	private String phone;
	private Double yuE;
	private Double huiYuanDengJi;
	private Integer quanXianDengJi;
	private String salt;
}

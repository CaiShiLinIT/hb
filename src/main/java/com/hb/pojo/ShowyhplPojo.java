package com.hb.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 用于封装展示菜品评价部分评论的数据
 * 所有名字前是showyhpl表示是一类
 * @author <dl>
 *
 */
@Data
@Accessors(chain=true)
@TableName("caipinpingjiabiao")
public class ShowyhplPojo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7198891359385445382L;
	@TableId(type=IdType.AUTO)
	private Integer pingJiaID;
	private Double pingFen;
	private String pingLun;
	private Date pingLunShiJian;
	private Integer caiDanID;
	private Integer fuJiID;
	private String yongHuMing;
	private Integer pid;
	
	
	
	

}

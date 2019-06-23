package com.hb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

public class ShangJiaPojo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String canTingMing;
	private String dianHua;
	private String diZhi;
	private String fuWuZongZhi;
	private String shangJiaTuPian;
	public String getCanTingMing() {
		return canTingMing;
	}
	public void setCanTingMing(String canTingMing) {
		this.canTingMing = canTingMing;
	}
	public String getDianHua() {
		return dianHua;
	}
	public void setDianHua(String dianHua) {
		this.dianHua = dianHua;
	}
	public String getDiZhi() {
		return diZhi;
	}
	public void setDiZhi(String diZhi) {
		this.diZhi = diZhi;
	}
	public String getFuWuZongZhi() {
		return fuWuZongZhi;
	}
	public void setFuWuZongZhi(String fuWuZongZhi) {
		this.fuWuZongZhi = fuWuZongZhi;
	}
	public String getShangJiaTuPian() {
		return shangJiaTuPian;
	}
	public void setShangJiaTuPian(String shangJiaTuPian) {
		this.shangJiaTuPian = shangJiaTuPian;
	}
	@Override
	public String toString() {
		return "ShangJiaPojo [canTingMing=" + canTingMing + ", dianHua=" + dianHua + ", diZhi=" + diZhi
				+ ", fuWuZongZhi=" + fuWuZongZhi + ", shangJiaTuPian=" + shangJiaTuPian + "]";
	}
	
}

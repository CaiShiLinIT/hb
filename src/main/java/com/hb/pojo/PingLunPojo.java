package com.hb.pojo;

import java.io.Serializable;
import java.util.Date;

public class PingLunPojo implements Serializable{
	private Integer pingJiaID;
	private Integer pingFen;
	private String pingLun;
	private Date pingLunShiJian;
	private String yongHuMing;
	private Integer caiDanID;
	private Integer fuJiID;
	private Integer pid;
	public Integer getPingJiaID() {
		return pingJiaID;
	}
	public void setPingJiaID(Integer pingJiaID) {
		this.pingJiaID = pingJiaID;
	}
	public Integer getPingFen() {
		return pingFen;
	}
	public void setPingFen(Integer pingFen) {
		this.pingFen = pingFen;
	}
	public String getPingLun() {
		return pingLun;
	}
	public void setPingLun(String pingLun) {
		this.pingLun = pingLun;
	}
	public Date getPingLunShiJian() {
		return pingLunShiJian;
	}
	public void setPingLunShiJian(Date pingLunShiJian) {
		this.pingLunShiJian = pingLunShiJian;
	}
	public String getYongHuMing() {
		return yongHuMing;
	}
	public void setYongHuMing(String yongHuMing) {
		this.yongHuMing = yongHuMing;
	}
	public Integer getCaiDanID() {
		return caiDanID;
	}
	public void setCaiDanID(Integer caiDanID) {
		this.caiDanID = caiDanID;
	}
	public Integer getFuJiID() {
		return fuJiID;
	}
	public void setFuJiID(Integer fuJiID) {
		this.fuJiID = fuJiID;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "PingLunPojo [pingJiaID=" + pingJiaID + ", pingFen=" + pingFen + ", pingLun=" + pingLun
				+ ", pingLunShiJian=" + pingLunShiJian + ", yongHuMing=" + yongHuMing + ", caiDanID=" + caiDanID
				+ ", fuJiID=" + fuJiID + ", pid=" + pid + "]";
	}
	
	
	
}

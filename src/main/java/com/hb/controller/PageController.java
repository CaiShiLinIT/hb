package com.hb.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.hb.common.exception.ServiceException;
import com.hb.entity.SysUser;
import com.hb.service.YongHuService;
import com.hb.util.SmsUtils;
import com.hb.vo.JsonResult;


//import com.java98k.alipay.service.DianYingService;



@Controller
@RequestMapping("/")
public class PageController {
	@Autowired
	private YongHuService yongHuService;
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
	
	@RequestMapping("doLogin2")
	public String doLogin2() {
		return "login2";
	}


	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(boolean isRememberMe,String username, String password) {
		// 提交用户信息到业务层
		// 1.获取主体对象（Subject）
		Subject subject = SecurityUtils.getSubject();
		// 2.提交信息（提交给shiro的securityManager）
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		if(isRememberMe) {
			token.setRememberMe(true); 
		}
		System.out.println(username);
		System.out.println(password);
		JsonResult r=new JsonResult(); 

		subject.login(token);
		return new JsonResult("login ok");
	}

	@RequestMapping("doForgetPwdUI")
	public String doForgetPwdUI() {
		return "forgetPwd";
	}

	@RequestMapping("doRegisterUI")
	public String doRegisterUI() {
		return "register";
	}

	@RequestMapping("doQiTaUI")
	public String doQiTaUI() {
		return "qtlogin";
	}
	@RequestMapping("doWangJiMiMa")
	@ResponseBody
	public JsonResult doWangJiMiMa(String phone){
		if (phone==null||StringUtils.isEmpty(phone)) {
			throw new IllegalArgumentException("手机号不能为空");
		}
		int rows = yongHuService.findByPhone(phone);
		if (rows==0) {
			throw new ServiceException("该手机号还未注册,请前往注册");
		}
		System.out.println("rows="+rows);
		System.out.println("phone="+phone);
		int newcode = (int)(Math.random()*9999)+100;  //每次调用生成一位四位数的随机数
		String code=Integer.toString(newcode);
		System.err.println(code);
		SendSmsResponse sendSms=null;
		try {
			sendSms= SmsUtils.sendSms(phone, code, "SMS_165414522");
		} catch (ClientException e) {
			e.printStackTrace();
		}
		System.err.println(sendSms.getMessage());
		return new JsonResult(code);
	}
	
	@RequestMapping("doUpdatePwd")
	@ResponseBody
	public JsonResult doUpdatePwd(String username,String newPwd,String cfgPwd) {
		yongHuService.updatePassword(username, newPwd, cfgPwd);
		return new JsonResult("update ok!");
	}
	@RequestMapping("doYanZheng")
	@ResponseBody
	public JsonResult doYanZheng(String phone) {
		System.err.println("*****************************");
		System.out.println(phone);
		int rows=0;
		try {
			rows = yongHuService.findByPhone(phone);
		} catch (Exception e) {
			System.err.println("chaxuncuowu ");
		}
		if (rows!=0) {
			throw new ServiceException("该手机号已注册,请前往登录");
		}
		int newcode = (int)(Math.random()*9999)+100;  //每次调用生成一位四位数的随机数
		String code=Integer.toString(newcode);
		System.err.println(code);
		SendSmsResponse sendSms=null;
		try {
			sendSms= SmsUtils.sendSms(phone, code, "SMS_165414518");
		} catch (ClientException e) {
			e.printStackTrace();
		}
		System.err.println(sendSms.getMessage());
		return new JsonResult(code);
	}
	
	@RequestMapping("doZhuCe")
	@ResponseBody
	public JsonResult doZhuCe(SysUser entity) {
		//String username,String password,String phone
		System.out.println(entity.getYongHuMing());
		System.out.println(entity);
		int rows=0;
		try {
			rows = yongHuService.insertUser(entity);
		} catch (Exception e) {
			throw new ServiceException("用户名重复");
		}
		if (rows==0) {
			throw new ServiceException("注册失败");
		}
		return new JsonResult("注册 OK！");
	}
	
	@RequestMapping("doDLYanZheng")
	@ResponseBody
	public JsonResult doDLYanZheng(String phone) {
		if (phone==null||StringUtils.isEmpty(phone)) {
			throw new IllegalArgumentException("手机号不能为空");
		}
		int rows = yongHuService.findByPhone(phone);
		if (rows==0) {
			throw new ServiceException("该手机号还未注册,请前往注册");
		}
		System.out.println("rows="+rows);
		System.err.println("*****************************");
		System.out.println(phone);
		int newcode = (int)(Math.random()*9999)+100;  //每次调用生成一位四位数的随机数
		String code=Integer.toString(newcode);
		System.err.println("验证码为："+code);
		SendSmsResponse sendSms=null;
		try {
			sendSms= SmsUtils.sendSms(phone, code, "SMS_165414524");
		} catch (ClientException e) {
			e.printStackTrace();
		}
		System.err.println(sendSms.getMessage());
		return new JsonResult(code);
	}

	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "index";
	}


}

package com.hb.service;

import com.hb.entity.SysUser;

public interface YongHuService {
	String findObjectByName(String userName);
	/**
	 * 基于用户名修改密码
	 * @param username
	 * @param newPassword
	 * @param cfgPassword
	 * @return
	 */
	int updatePassword(String username,
					   String newPwd,
					   String cfgPwd
					   );
	int insertUser(SysUser entity);
	int findByPhone(String phone);
}

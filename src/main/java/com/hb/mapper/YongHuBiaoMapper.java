package com.hb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hb.entity.SysUser;
import com.hb.pojo.YongHuBiao;

public interface YongHuBiaoMapper extends BaseMapper<YongHuBiao> {

	@Select("select * from yonghubiao where yongHuMing=#{username}")
	SysUser findUserByUserName(String username);
	
	@Select("select count(*) from yonghubiao where phone=#{phone}")
	int findByPhone(String phone);
	
	/**
	 * 基于用户名修改密码
	 * @param username
	 * @param newPassword
	 * @param cfgPassword
	 * @return
	 */
	@Update("update yonghubiao set miMa=#{cfgPwd},salt=#{newPwd} where yongHuMing=#{username}")
	int updatePassword(String username,String newPwd,String cfgPwd);
	
	@Insert("insert into yonghubiao(yongHuMing,miMa,diZhi,phone,yuE,huiYuanDengJi,quanXianDengJi,salt) "
			+ "values(#{yongHuMing},#{miMa},#{diZhi},#{phone},#{yuE},1.0,1,#{salt})")
	int insertUser(SysUser entity);
}

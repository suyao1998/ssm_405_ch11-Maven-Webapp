package com.tcf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tcf.entity.SmbmsUser;

public interface SmbmsUserDao {
	SmbmsUser login(SmbmsUser user);
	int changePassword(@Param("userCode") String userCode,@Param("userPassword") String userPassword,@Param("newPwd") String newPwd);
	int addSmbmsUser(SmbmsUser user);
	int delSmbmsUser(String userCode);
	int updateSmbmsUser(SmbmsUser user);
	SmbmsUser getSmbmsUserById(Long id);
	List<SmbmsUser> getSmbmsUsers(@Param("userName") String userName,@Param("userRole") Integer userRole,
			@Param("begin") int begin,@Param("size") int size);
	int getUserRows(@Param("userName") String userName,@Param("userRole") Integer userRole);
}

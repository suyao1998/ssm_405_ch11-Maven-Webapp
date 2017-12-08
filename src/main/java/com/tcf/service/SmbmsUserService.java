package com.tcf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tcf.entity.SmbmsUser;

public interface SmbmsUserService {
	int addSmbmsUser(SmbmsUser user);
	int updateSmbmsUser(SmbmsUser user);
	SmbmsUser login(SmbmsUser user);
	int changePassword(String userCode, String userPassword,
			String newPwd);
	List<SmbmsUser> getSmbmsUsers(String userName,Integer userRole,
			int pageIndex,int pageSize);
	int getUserRows(String userName,Integer userRole);
	SmbmsUser getById(Long id);
	
}

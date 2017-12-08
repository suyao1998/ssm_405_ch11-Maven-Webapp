package com.tcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcf.dao.SmbmsUserDao;
import com.tcf.entity.SmbmsUser;
import com.tcf.service.SmbmsUserService;

@Service
public class SmbmsUserServiceImpl implements SmbmsUserService {
	
	@Autowired
	private SmbmsUserDao dao;
	
	@Override
	public SmbmsUser login(SmbmsUser user) {
		// TODO Auto-generated method stub
		return dao.login(user);
	}
	
	@Override
	public int changePassword(String userCode, String userPassword,
			String newPwd) {
		// TODO Auto-generated method stub
		return dao.changePassword(userCode, userPassword, newPwd);
	}

	@Override
	public List<SmbmsUser> getSmbmsUsers(String userName, Integer userRole,
			int pageIndex,int pageSize) {
		// TODO Auto-generated method stub
		return dao.getSmbmsUsers(userName, userRole, (pageIndex-1)*pageSize, pageSize);
	}

	@Override
	public int getUserRows(String userName, Integer userRole) {
		// TODO Auto-generated method stub
		return dao.getUserRows(userName, userRole);
	}

	@Override
	public int addSmbmsUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		return dao.addSmbmsUser(user);
	}

	@Override
	public SmbmsUser getById(Long id) {
		// TODO Auto-generated method stub
		return dao.getSmbmsUserById(id);
	}

	@Override
	public int updateSmbmsUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		return dao.updateSmbmsUser(user);
	}
}

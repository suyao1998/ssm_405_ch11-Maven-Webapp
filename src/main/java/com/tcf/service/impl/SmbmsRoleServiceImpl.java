package com.tcf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcf.dao.SmbmsRoleDao;
import com.tcf.entity.SmbmsRole;
import com.tcf.service.SmbmsRoleService;

@Service
public class SmbmsRoleServiceImpl implements SmbmsRoleService {
	
	@Autowired
	private SmbmsRoleDao dao;
	
	@Override
	public List<SmbmsRole> getSmbmsRoles() {
		// TODO Auto-generated method stub
		return dao.getSmbmsRoles();
	}
}

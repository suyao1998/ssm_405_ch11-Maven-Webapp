package com.tcf.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tcf.entity.SmbmsUser;
import com.tcf.service.SmbmsUserService;

public class TestSmbmsUser {
	
	/*@Test
	public void login(){
		//ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext-base.xml","applicationContext-dao.xml","applicationContext-service.xml");
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath*:applicationContext-*.xml");
		SmbmsUserService ss = (SmbmsUserService) app.getBean("smbmsUserServiceImpl");
		SmbmsUser user = new SmbmsUser("admin", "123");
		SmbmsUser logined = ss.login(user);
		Assert.assertTrue(logined.getUserCode().equals(user.getUserCode()));
		//Assert.assertEquals(true, logined.getUserCode().equals(user.getUserCode()));
	}*/
	/*@Test
	public void changePassword(){
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		SmbmsUserService ss = (SmbmsUserService) app.getBean("smbmsUserServiceImpl");
		int result = ss.changePassword("admin", "wan", "123");
		Assert.assertTrue(result == 1);
	}*/
}

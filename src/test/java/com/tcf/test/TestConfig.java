package com.tcf.test;

import junit.framework.Assert;

import org.junit.Test;

import com.tcf.util.Configuration1;
import com.tcf.util.Configuration2;
import com.tcf.util.Configuration3;

public class TestConfig {

	@Test
	public void test1(){
		/*Configuration1 cfg = new Configuration1();
		String username = cfg.getVal("username");
		Assert.assertEquals("root", username);*/
		
		String username = Configuration1.getInstance().getVal("username");
		Assert.assertEquals("root", username);
	}
	
	@Test
	public void test2(){
		String username = Configuration2.getInstance().getVal("username");
		Assert.assertEquals("root", username);
	}
	
	@Test
	public void test3(){
		String username = Configuration3.getInstance().getVal("username");
		Assert.assertEquals("root", username);
	}
}

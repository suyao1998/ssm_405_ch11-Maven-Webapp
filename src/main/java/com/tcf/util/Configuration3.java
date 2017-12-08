package com.tcf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class Configuration3 {
	
	private Properties prop = new Properties();
	
	private Configuration3() {
		InputStream is;
		try {
			//is = Resources.getResourceAsStream("datasource.properties");
			is = Configuration3.class.getClassLoader().getResourceAsStream("datasource.properties");
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static class Singleton{
		private static Configuration3 cfg = new Configuration3();
	}
	public static Configuration3 getInstance(){
		return Singleton.cfg;
	}
	public String getVal(String key){
		return prop.getProperty(key);
	}
}

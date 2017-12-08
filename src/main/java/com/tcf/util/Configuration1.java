package com.tcf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class Configuration1 {
	
	private Properties prop = new Properties();
	
	private Configuration1() {
		InputStream is;
		try {
			//is = Resources.getResourceAsStream("datasource.properties");
			is = Configuration1.class.getClassLoader().getResourceAsStream("datasource.properties");
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Configuration1 cfg;
	public static Configuration1 getInstance(){
		if(cfg == null){
			cfg = new Configuration1();
		}
		return cfg;
	}
	public String getVal(String key){
		return prop.getProperty(key);
	}
}

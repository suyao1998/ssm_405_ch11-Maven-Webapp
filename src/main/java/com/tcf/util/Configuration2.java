package com.tcf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class Configuration2 {
	
	private Properties prop = new Properties();
	
	private Configuration2() {
		InputStream is;
		try {
			//is = Resources.getResourceAsStream("datasource.properties");
			is = Configuration2.class.getClassLoader().getResourceAsStream("datasource.properties");
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Configuration2 cfg = new Configuration2();
	public static Configuration2 getInstance(){
		return cfg;
	}
	public String getVal(String key){
		return prop.getProperty(key);
	}
}

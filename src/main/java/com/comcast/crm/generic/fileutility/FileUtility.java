package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import interfaceiconstant.Iconstant;

public class FileUtility {
	String path=Iconstant.path;
	public String getDataFromPropertyFile(String key) throws Throwable {
		
		FileInputStream fis=new FileInputStream(path);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		
		return value;
		}

}

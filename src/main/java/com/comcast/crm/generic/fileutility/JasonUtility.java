package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JasonUtility {
	
	public String getDataFromJasonFile(String path, String key) throws Throwable {
		
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader(path));
		
		JSONObject map=(JSONObject)obj;
		
	    String value= map.get(key).toString();
		
	    return value;
		
		
       
  
		}

}

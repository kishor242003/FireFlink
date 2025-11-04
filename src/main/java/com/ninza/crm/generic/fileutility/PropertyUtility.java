package com.ninza.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
		
	}

}

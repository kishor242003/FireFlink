package com.ninza.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJsomFile(String key) throws IOException, ParseException {
		FileReader fr=new FileReader("./data/CommonData.json");
		JSONParser jp=new JSONParser();
		Object obj = jp.parse(fr);
		JSONObject jObj=(JSONObject)obj;
		String data=jObj.get(key).toString();
		
		return data;
	}

}

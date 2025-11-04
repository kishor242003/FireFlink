package Practice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json {

	public static void main(String[] args) throws IOException, ParseException {
FileReader fr=new FileReader("./data/CommonData.json");
JSONParser jp=new JSONParser();
Object obj=jp.parse(fr);
JSONObject jObj=(JSONObject)obj;
String BROWSER=jObj.get("browser").toString();
String URL=jObj.get("url").toString();
String USERNAME=jObj.get("username").toString();
String PASSWORD=jObj.get("password").toString();
System.out.println(BROWSER);
System.out.println(URL);
System.out.println(USERNAME);
System.out.println(PASSWORD);
	}

}

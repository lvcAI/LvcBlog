package party.pjc.blog.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String getValue(String key){
		Properties prop =new Properties();
		InputStream in = new PropertiesUtil().getClass().getResourceAsStream("/lvcblog.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (String) prop.get(key);
	} 
}

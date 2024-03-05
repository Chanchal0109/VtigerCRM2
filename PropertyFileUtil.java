package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {
 
	public String getDataFromProertyfile(String key) throws IOException
	{
		FileInputStream fs = new FileInputStream("src\\test\\resources\\vtiger.properties");
		Properties p = new Properties();
		p.load(fs);
	  String value=p.getProperty(key);
		return value;
	}
	
	public String getData(String key1) throws IOException
	{
		FileInputStream fs = new FileInputStream("src\\test\\resources\\Doc1.properties");
		Properties p = new Properties();
		p.load(fs);
	  String value1=p.getProperty(key1);
		return value1;
	}
	
		
	

}

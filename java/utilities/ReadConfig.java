package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
Properties pro;
public ReadConfig()
{
	try {
	File fo=new File("./Configuration/config.properties");
	FileInputStream fis;
	
		fis = new FileInputStream(fo);
		pro = new Properties();
		pro.load(fis);
	} catch (FileNotFoundException e) {
		System.out.println("Configuration file not found"+e.getMessage());
	} catch (IOException e) {
		System.out.println("Unable to load config file"+e.getMessage());
	}
	
}
public String getApplicationUrl() {
	String url=pro.getProperty("baseURL");
	return url;
}
public String getChromePath() {
	String ChromePath =pro.getProperty("chromepath");
			return ChromePath;
}
public String getFireFoxPath() {
	String FireFoxPath=pro.getProperty("firefoxpath");
	return FireFoxPath;
}
}

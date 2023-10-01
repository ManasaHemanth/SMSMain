package com.SMS.genericutils;





import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method is used to fetch common data present inside the property file 
	 * @param Key
	 * @return 
	 * @throws Throwable 
	 * @throws IOException 
	 * @throws  IOException
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.propertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);

		
	}
}

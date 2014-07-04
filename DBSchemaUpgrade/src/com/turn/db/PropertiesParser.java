package com.turn.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class PropertiesParser {

	public static Map<String , String > getDBSchemaPropertyDetails(){ 

		Map<String , String > dbMap = new HashMap<String, String>();
		FileInputStream fileInput = null;
		try {
			File file=new File("DBSchema.properties");
			fileInput=new FileInputStream(file);
			Properties properties=new Properties();
			properties.load(fileInput);

			Enumeration<Object> enuKeys=properties.keys();
			String key = null;
			String value = null;
			while(enuKeys.hasMoreElements()){
				key=enuKeys.nextElement()+"";
				value=properties.getProperty(key);				
				dbMap.put(key, value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fileInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dbMap;
	}
}







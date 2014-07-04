package com.turn.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class UpgradeDBSchema {


	public static void main(String[] args) {
		String pID = ".DBConnection.Version:";
		PrintWriter out = null;
		Map<String , String> schemaMap = null;
		Map<String,Integer> schemaUpdateMap = null;
		BufferedReader br = null;
		try {

			schemaMap = PropertiesParser.getDBSchemaPropertyDetails();

			schemaUpdateMap=FetchSchemaVersion.getSchemaVersion(schemaMap);

			System.out.println("----------------------------------------");

			File originalFile = new File(schemaMap.get("DB_CONFIG_PATH"));
			br = new BufferedReader(new FileReader(originalFile));

			String line = null;
			StringBuilder sb = new StringBuilder();
			String schemaName = null;
			
			while ((line = br.readLine()) != null) {

				if( line.indexOf(pID)!=-1 ){
					schemaName = line.substring(0,line.indexOf(pID));
					if( schemaName!=null ){
						for (int i = 0; i < schemaMap.size(); i++) {
							if( schemaMap.containsKey(schemaName) ){
								if (line.contains(schemaName+pID)) {
									line = schemaName + pID+ schemaUpdateMap.get(schemaName);
								}
							}
						}
					}
				}
				sb.append(line + "\n");
			}
			out = new PrintWriter(schemaMap.get("DB_CONFIG_PATH"));
			out.print(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.flush();
			out.close();
		}
		
		System.out.println("db.config.txt updated successfully.");
		
	}

}
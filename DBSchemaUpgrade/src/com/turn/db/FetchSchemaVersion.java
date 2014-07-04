package com.turn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FetchSchemaVersion {

	public static Map<String ,Integer> getSchemaVersion(final Map<String, String> schemaMap){

		Map<String ,Integer> schemaUpdate=new HashMap<String, Integer>();
		PreparedStatement ps=null;
		Connection connection = null;
		ResultSet rs=null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle JDBC Driver Registered!");
			System.out.println("------------------------------------");

			if( schemaMap !=null && !schemaMap.isEmpty() ){
				Set<String> schemasSet = schemaMap.keySet();
				String userpass[] = null;
				for (String schemaName : schemasSet) {

					String value= schemaMap.get(schemaName);
					if( value.indexOf(",")!=-1 ){
						userpass = value.split(",");

						connection = DriverManager.getConnection(
								"jdbc:oracle:thin:@172.25.54.126:1521:QAAPP01", userpass[0],userpass[1]);

						ps = connection.prepareStatement
								("SELECT max(schema_version) as schema_version FROM schema_info");

						rs = ps.executeQuery();

						if(rs.next()){
							System.out.println(schemaName+" version is : "+ rs.getInt("schema_version"));
							schemaUpdate.put(schemaName, rs.getInt("schema_version"));
						}
					}

				}


			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	

		return schemaUpdate;

	}
}

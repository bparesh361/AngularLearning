package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.javasimon.SimonManager;
import org.javasimon.Split;
import org.javasimon.Stopwatch;
import org.javasimon.utils.SimonUtils;

public class JDBCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:simon:mysql://localhost/test","root","root");
		Stopwatch stopwatch = SimonManager.getStopwatch("test-jdbc");
		Split split = stopwatch.start();
		TestDao dao = new TestDao(con);
		dao.fetchData();
		split.stop();
		System.out.println(" --- Simon Hierarchy --- " + SimonUtils.simonTreeString(SimonManager.getRootSimon()));		
	}

}

class TestDao {

	private Connection con;
	
	static {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Class.forName("org.javasimon.jdbc4.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public TestDao(Connection con) {		
		this.con = con;
	}



	public void fetchData() throws Exception {		
		Split split = SimonManager.getStopwatch("test-jdbc").start();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user");
		while(rs.next()){
			System.out.println("-------------------------------"+rs.getString("pwd"));
		}
		con.close();
		split.stop();
		
	}

}

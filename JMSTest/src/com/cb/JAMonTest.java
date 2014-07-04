package com.cb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JAMonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		 String x = "1393911934483";
		    long foo = Long.parseLong(x);
		    System.out.println(x + "\n" + foo);

		    Date date = new Date(foo);
		    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    System.out.println(formatter.format(date)); 
		
		
	}
	
	private String convertToGMT(Date date)
	 {
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	  dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	  return dateFormat.format(date);
	 }


	}



package com.test;

import org.javasimon.SimonManager;
import org.javasimon.Split;
import org.javasimon.Stopwatch;

public class StrangeMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Stopwatch stopwatch = SimonManager.getStopwatch("test-random");
		for(int x=0;x<10;x++){
			Test.strangeMethod();
		}
		System.out.println(stopwatch);
		System.out.println(stopwatch.sample());
	}

}

class Test{
	
	public static void strangeMethod() throws Exception {
		Stopwatch stopwatch = SimonManager.getStopwatch("test-random");
		Split split = stopwatch.start();
		long waittime = (long)Math.random()*50;
		System.out.println("--------------------"+waittime);
		Thread.sleep(waittime);
		split.stop();
	}
	
}

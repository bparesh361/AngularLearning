package com.test;

import java.util.Iterator;

import org.javasimon.Simon;
import org.javasimon.SimonManager;
import org.javasimon.Split;
import org.javasimon.Stopwatch;
import org.javasimon.StopwatchSample;
import org.javasimon.callback.timeline.StopwatchTimeRange;
import org.javasimon.console.SimonVisitors;
import org.w3c.dom.stylesheets.StyleSheet;
import org.w3c.dom.stylesheets.StyleSheetList;

public class HelloWorld {

	public static void main(String args[]){
		
		Stopwatch stopwatch = SimonManager.getStopwatch("HelloWorld_Request");
		
		Split split = stopwatch.start();
		
//		System.out.println(" ==== Hello World === " + stopwatch.sampleAndReset());
//		stopwatch.sample().setCounter(12);
		
		System.out.println(stopwatch.sample().getCounter());
		stopwatch.sample().setCounter(10);
		
		split.stop();
	
		
		System.out.println(stopwatch.sample().getCounter());
		System.out.println(stopwatch);
		
		System.out.println(stopwatch.getMax());
		System.out.println(stopwatch.getMin());
		System.out.println(stopwatch.getMinTimestamp());
		System.out.println(stopwatch.getTotal());
		System.out.println(stopwatch.sample());
		
		StopwatchSample sample = new StopwatchSample();
		
		//		Simon simon = SimonManager.getSimon("HelloWorld_Request");
		System.out.println(stopwatch.getCounter());
//		System.out.println(simon.getLastReset());
//		System.out.println(simon.getLastUsage());
//		System.out.println(simon.getName());
//		System.out.println(simon.getNote());
//		
		
		
//            Stopwatch stopwatch1 = SimonManager.getStopwatch("stopwatch");
//             simon = SimonManager.getSimon("stopwatch");
//             System.out.println(simon.getName());
//            for (int i = 0; i < 10; i++) {
//                    strangeMethod();
//            }
//            System.out.println("----------Stopwatch: " + stopwatch1);
    

    /**
     * Method that lasts randomly from ~0 to ~2500 ms.
     */
   
		
	}
	 private static void strangeMethod() {
         Split split = SimonManager.getStopwatch("stopwatch").start();
         long random = (long) (Math.random() * 50);
         try {
                 Thread.sleep(random * random);
         } catch (InterruptedException e) {
                 e.printStackTrace();
         }
         split.stop();
 }
	
}

package com.test;

import org.javasimon.SimonManager;
import org.javasimon.Stopwatch;

public class Sampler extends Thread {

	@Override
	public void run() {		
		while(true){
			Stopwatch stopwatch = SimonManager.getStopwatch("test-random");
			System.out.println("Stop Watch = " + stopwatch);
			System.out.println(" Stopwatch Sample " + stopwatch.sample());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
}

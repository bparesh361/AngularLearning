package com.test;

public class SamplerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Sampler sampler = new Sampler();
		sampler.start();
		while(true){
			Test.strangeMethod();
		}

	}

}

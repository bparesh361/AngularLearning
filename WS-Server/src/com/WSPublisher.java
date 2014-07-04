package com;

import javax.xml.ws.Endpoint;

import com.cb.GreetingImpl;

public class WSPublisher {
	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:8080/WS/Greeting",new GreetingImpl());
		System.out.println("Endpoint created successfully");
		
		}
}

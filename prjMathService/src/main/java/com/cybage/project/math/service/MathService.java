package com.cybage.project.math.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {

	public double sqrt(Double number) {
		return Math.sqrt(number);
	}
	
}

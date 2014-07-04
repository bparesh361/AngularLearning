package com.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.javasimon.SimonManager;
import org.javasimon.Split;
import org.javasimon.Stopwatch;

@Aspect
public class LoginAspect {
	@Around("execution(* com.test.dao.LoginDao.*(..))")
	public Object simonAspectcheckUser(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println(" --- Login Interceptor --- ");
		Stopwatch stopwatch = SimonManager.getStopwatch("Login-simon-spring-interceptor");
		Split split = stopwatch.start();
		Object obj = joinpoint.proceed();
		split.stop();
		return obj;
	}	

	@Around("execution(* com.test.dao.LoginDao.insertUser(..))")
	public Object simonAspectinsertUser(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println(" --- Insert user intercepter Interceptor --- ");
		Stopwatch stopwatch = SimonManager.getStopwatch("insert-simon-spring-interceptor");
		Split split = stopwatch.start();
		Object obj = joinpoint.proceed();
		split.stop();
		return obj;
	}	
}

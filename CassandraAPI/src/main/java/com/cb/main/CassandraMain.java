package com.cb.main;

import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hom.EntityManagerImpl;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cb.entity.User;

public class CassandraMain {

	public static ApplicationContext context = null;
	public static BeanFactory factory = null;

	static {
		context = new ClassPathXmlApplicationContext(
				"classpath:/spring-cassandra.xml");
		factory = (BeanFactory) context;
	}

	public static void main(String s[]) {
		System.out.println("Inside Cassandra main method.");
		Cluster cluster = null;
		try{
		cluster = (Cluster)factory.getBean("cluster");
		System.out.println("Fatching the cluster : "+cluster);
		User user =insertingUserInDB();
		System.out.println("User is inserted in DB successfully."+user.getUserId());
		System.out.println("--------------------------Reading the data ----------------------");
		readMetricsRequestCollection();
		
		}catch(Exception e){
			System.out.println("Exception is ----------------------: "+e.getMessage());
			e.printStackTrace();
		}finally{
			cluster.getConnectionManager().shutdown();
			System.out.println("Closing the cluster");
		}
	}
	
	public static EntityManagerImpl getEntityManager(){
		return (EntityManagerImpl) factory.getBean("entityManager");
	}

	public static User insertingUserInDB(){
		
		EntityManagerImpl em = getEntityManager();		
		User user = cretingUser();		
		em.persist(user);
		return user;
		
	}
	
public static User cretingUser(){
		
		User user = new User();		
		user.setUserId(555);
		user.setfName("Smith");
		user.setlName("Nelson");
		return user;
	}

public static void readMetricsRequestCollection(){
	EntityManagerImpl em = getEntityManager();
	User user = em.find(User.class,678);		
	System.out.println("get name : " + user.getUserId());
	System.out.println("get name : " + user.getfName());
	System.out.println("get name : " + user.getlName());
}
}

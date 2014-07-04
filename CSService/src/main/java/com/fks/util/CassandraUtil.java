package com.fks.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Component
public class CassandraUtil {
	
	private static Logger logger = Logger.getLogger(CassandraUtil.class);
	
	private static Cluster cluster;
	
	public CassandraUtil(){
		logger.info(" --- Building Cassandra Cluster --- ");
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();		
		logger.info("Cluster name :"+cluster.getClusterName());
	}	
	
	public Session getSession(){
		return cluster.connect("simplex");
	}

}

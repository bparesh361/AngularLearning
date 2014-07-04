package com.company.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.company.dao")
public class JPAConfiguration {

	@Bean(name="dataSource")
	public DataSource dataSource(){
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		datasource.setUrl("jdbc:mysql://localhost:3306/student");
		datasource.setUsername("root");
		datasource.setPassword("root");
		return datasource;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		containerEntityManagerFactoryBean.setDataSource(dataSource());
		HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
		containerEntityManagerFactoryBean.setJpaVendorAdapter(adaptor);
		containerEntityManagerFactoryBean.setPackagesToScan("com.company.entity");
		Properties props = new Properties();		
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		containerEntityManagerFactoryBean.setJpaProperties(props);
		return containerEntityManagerFactoryBean;
	}
	
	/*@Bean
	public TransactionManager transactionManager(){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setDataSource(dataSource());
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
		return transactionManager();
	}*/
	
}

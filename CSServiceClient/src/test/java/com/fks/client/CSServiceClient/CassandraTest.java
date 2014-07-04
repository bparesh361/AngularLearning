package com.fks.client.CSServiceClient;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class CassandraTest {

	private static RestTemplate restTemplate;
	
	@BeforeClass
	public static void init(){
		System.out.println(" ---- Inside Initializing Resources ---- ");
		restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters);
	}
	
	@AfterClass
	public static void tearDown(){
		System.out.println(" --- Inside Destroying Resources --- ");
		restTemplate = null;
	}
	
	@Test
	public void test(){
		Assert.assertEquals("123", "123");
	}
	
	@Test
	public void testGetUserById(){				
		UserVO vo = restTemplate.getForObject("http://10.0.40.18:8080/CSService/cservice/users/123",UserVO.class);
		Assert.assertNull(vo);
		System.out.println(vo);		
	}
	
	
}

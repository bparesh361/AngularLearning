package com.cybage.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cybage.project.auth.AuthEndPoint;
import com.cybage.project.auth.AuthException;
import com.cybage.project.schemas.AuthRequest;
import com.cybage.project.schemas.AuthResponse;
import com.cybage.project.schemas.MathSqrtRequest;
import com.cybage.project.schemas.MathSqrtResponse;
import com.cybage.project.schemas.RegisterRequest;
import com.cybage.project.schemas.RegisterResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-ws-auth-servlet.test.xml")
public class AuthServiceTest {
	@Autowired
	private AuthEndPoint authEndPoint;
	
	@Test
	public void testAuthEndPointForNull(){
		Assert.assertNotNull(authEndPoint);
	}
	
	// test for registration
		@Test
		public void testRegisterService() throws AuthException {
			RegisterRequest request = new RegisterRequest();
			request.setUsername("admin");
			request.setPassword("password");
			RegisterResponse response = authEndPoint.register(request);
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getMsg());
			System.out.println(response.getMsg());
		}	
		
		// test for authentication and key generation
		@Test
		public void testAuthentication() throws AuthException {
			RegisterRequest request = new RegisterRequest();
			request.setUsername("admin");
			request.setPassword("password");
			RegisterResponse response = authEndPoint.register(request);
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getMsg());
			AuthRequest authrequest  = new AuthRequest();
			authrequest.setUsername("admin");
			authrequest.setPassword("password");
			AuthResponse authResponse = authEndPoint.auth(authrequest);
			Assert.assertNotNull(authResponse.getKey());
			System.out.println(" ---- Key ---- " + authResponse.getKey());
		}
		
		// test for square root
		@Test
		public void testMathSquareRoot() throws AuthException {
			RegisterRequest request = new RegisterRequest();
			request.setUsername("admin");
			request.setPassword("password");
			RegisterResponse response = authEndPoint.register(request);
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getMsg());
			AuthRequest authrequest  = new AuthRequest();
			authrequest.setUsername("admin");
			authrequest.setPassword("password");
			AuthResponse authResponse = authEndPoint.auth(authrequest);
			Assert.assertNotNull(authResponse.getKey());
			MathSqrtRequest mathSqrtRequest = new MathSqrtRequest();
			mathSqrtRequest.setKey(authResponse.getKey());
			mathSqrtRequest.setNumber(9);
			MathSqrtResponse mathSqrtResponse = authEndPoint.getSqrt(mathSqrtRequest);
			Assert.assertNotNull(mathSqrtResponse);
			Assert.assertEquals(mathSqrtResponse.getNumber(), 3, 0);
		}

	
	
}

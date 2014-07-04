package com.company.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component(value="authSuccessHandler")
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		String username = request.getParameter("j_username");
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());
		HttpSession session = request.getSession(true);
		session.setAttribute("roles", roles);
		session.setAttribute("username", username);
		if (roles.contains("ROLE_ADMIN")) {
			response.sendRedirect("auth/home.do");
		} else {
			response.sendRedirect("auth/home.do");
		}		
	}
}

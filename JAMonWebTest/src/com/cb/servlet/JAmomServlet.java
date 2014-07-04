package com.cb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jamonapi.MonKey;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

/**
 * Servlet implementation class JAmomServlet
 */
public class JAmomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Monitor userMon;
     private Monitor sessionMon;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JAmomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "https://www.google.co.in";
	        Monitor mon=MonitorFactory.start("www.google.com  ::::"+url);   
	              
	        response.setContentType( "text/html" );
	        PrintWriter out = response.getWriter();
	        try {                    
	            HttpSession session = request.getSession();
	            String username =(String)session.getAttribute("username");
	        	
	            out.println("Ip Adress :"+mon.getLabel()+"\n </br>" );
	            out.println("First Access :"+mon.getFirstAccess()+"\n</br>");
	            out.println("Active :"+mon.getActive()+"\n</br>");
	            out.println("Avg :"+mon.getAvg()+"\n</br>");
	            out.println("Avg Active :"+mon.getAvgActive()+"\n</br>");
	            out.println("Hits :"+mon.getHits()+"\n</br>");
	            out.println("Last Access :"+mon.getLastAccess()+"\n</br>");
	            
	            sessionMon = MonitorFactory.start("MyAppName.allSessions");
	            userMon = MonitorFactory.start("MyAppName.session."+username);
	            System.out.println(username);
	            System.out.println(userMon.getHits());
	           
	        }
	        catch(Exception e) {
	            throw new ServletException(e.getMessage());
	        }
	        finally {
	            mon.stop();
	           // byDate.stop();
	          
	            
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	 private String getDate()     {
	        return DateFormat.getDateInstance(DateFormat.SHORT).format(new Date());
	    }
	  private String getFormattedIP(HttpServletRequest request)     {
	        String ip=request.getRemoteAddr();
	         if (ip==null || "".equals(ip))
	            return "";
	        else
	            return ip.replace('.', '-');
	    }


	  protected String getURI(ServletRequest request){
	       if (request instanceof HttpServletRequest) {
	    	   return ((HttpServletRequest)request).getRequestURI();
	       }
	       else
	        return "Not an HttpServletRequest";
	     }
	 

}

package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class MyFilter1 implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter1() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	        throws IOException, ServletException {
	    
	    response.setContentType("text/html");
	    PrintWriter writer = response.getWriter();
	    
	    try {
	        String usageParam = request.getParameter("uage");
	        
	        // Check if parameter is null or empty
	        if (usageParam == null || usageParam.isEmpty()) {
	            writer.println("Parameter 'usage' is missing. Please enter your age.");
	            request.getRequestDispatcher("form.html").include(request, response);
	            return; // stop further processing
	        }

	        int age = Integer.parseInt(usageParam);

	        if (age > 20) {
	            // pass the request along the chain
	            chain.doFilter(request, response);
	        } else {
	            writer.println("You are not eligible for marriage; your age is below 20 years.");
	            request.getRequestDispatcher("form.html").include(request, response);
	        }

	    } catch (NumberFormatException e) {
	        writer.println("Invalid age value. Please enter a valid number.");
	        request.getRequestDispatcher("form.html").include(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        writer.println("Something went wrong. Try again.");
	    }
	}


	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

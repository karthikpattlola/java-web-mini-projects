package com.tcs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uqal=request.getParameter("uqal");
		String udesig=request.getParameter("udesig");
		
		Cookie cookie3= new Cookie("uqual", uqal);
		Cookie cookie4= new Cookie("udesig", udesig);
		
		response.addCookie(cookie3);
		response.addCookie(cookie4);
		
		request.getRequestDispatcher("form3.html").forward(request, response);
	}

}

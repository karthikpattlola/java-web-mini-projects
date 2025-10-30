package com.tcs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//2-request //4-cookies are stored in request object
		Cookie[] cookies=request.getCookies();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html>");
		out.println("<body bgcolor='pink'>");
		out.println("<center><h1>");
		out.println("<br><br>");
		
		out.println("User Name..."+cookies[0].getValue()+"<br><br>");
		out.println("User Age..."+cookies[1].getValue()+"<br><br>");
		out.println("User Name..."+cookies[2].getValue()+"<br><br>");
		out.println("Qualification..."+cookies[3].getValue()+"<br><br>");
		
		
		out.println("Email..."+request.getParameter("email")+"<br><br>");
		out.println("Mobile..."+request.getParameter("mobile")+"<br><br>");
		
		out.println("<h1></center>");
		out.println("</body>");
		out.println("</html>");
		
	}

}

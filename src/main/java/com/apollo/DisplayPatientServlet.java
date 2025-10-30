package com.apollo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DisplayPatientServlet")
public class DisplayPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "Temple", 
                "apple"
            );

            PreparedStatement ps = con.prepareStatement("SELECT * FROM patient");
            ResultSet rs = ps.executeQuery();

            out.println("<h2>Patient List</h2>");
            out.println("<table border='1' cellpadding='8'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Gender</th><th>Disease</th><th>Address</th></tr>");

            while(rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
                out.println("<td>" + rs.getString(5) + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            con.close();

        } catch(Exception e) {
            out.println("<h3>Error: " + e.toString() + "</h3>");
        }
    }

}

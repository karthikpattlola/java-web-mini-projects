package com.apollo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPatientServlet
 */
@WebServlet("/AddPatientServlet")
public class AddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int pid = Integer.parseInt(request.getParameter("pid"));
        String pname = request.getParameter("pname");
        String gender = request.getParameter("gender");
        String disease = request.getParameter("disease");
        String address = request.getParameter("address");

        java.io.PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Temple","apple");
            java.sql.PreparedStatement ps = con.prepareStatement("INSERT INTO patient VALUES (?, ?, ?, ?, ?)");

            ps.setInt(1, pid);
            ps.setString(2, pname);
            ps.setString(3, gender);
            ps.setString(4, disease);
            ps.setString(5, address);

            int result = ps.executeUpdate();

            if(result > 0) {
                out.println("<h2>Patient Added Successfully!</h2>");
                out.println("<a href='DisplayPatientServlet'>View All Patients</a>");
            } else {
                out.println("<h2>Failed to Add Patient!</h2>");
            }

            con.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.toString() + "</h3>");
        }
    }
}
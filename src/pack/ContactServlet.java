package pack;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	
	Connection conn=null;
	PreparedStatement ps=null;
	
	@Override
	public void init() throws ServletException{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Pratiksha","system");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String txtname=request.getParameter("txtname");
		String mob=request.getParameter("mob");
		String email=request.getParameter("email");
		String location=request.getParameter("location");
		
	try{
		PreparedStatement ps=conn.prepareStatement("insert into contactus(txtname,mob,email,location) values (?,?,?,?)");
		
		ps.setString(1,txtname);
		ps.setString(2,mob);
		ps.setString(3,email);
		ps.setString(4,location);
		
		int result=ps.executeUpdate();
		if(result>0){
			out.println("<h3>Record Sucessfully Inserted </h3>");  
		}
		else{
			out.println("<h3>Some error occured</h3>");
		}
		}
	catch(Exception e){
		System.out.println(e.getMessage());
		}
	}
	
		public void destroy(){
			try{
				conn.close();
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		

}

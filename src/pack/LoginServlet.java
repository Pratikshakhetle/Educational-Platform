package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String uid=req.getParameter("uid").trim();
		String pass=req.getParameter("pass").trim();
		Login l=new Login();
		l.setUid(uid);
		l.setPass(pass);
		
		boolean status=l.status(l);
		if(status){
			req.setAttribute("username", uid);
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.forward(req, res);
		}
		else{
			out.println("<h2>Incorrect Password and Username</h2>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
		}
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.userservice;

@WebServlet("/login")
public class login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String email=req.getParameter("email");
     String password=req.getParameter("password");
     userservice service=new userservice();
     if(service.login(email, password))
     {
    	 resp.getWriter().print("<h1 style='color:blue'>login sucess</h1>");
    	 req.getRequestDispatcher("home.jsp").include(req, resp);
    	 
     }
     else
     {
    	 resp.getWriter().print("<h1 style='color:blue'>invalid credentials</h1>") ; 
    	 req.getRequestDispatcher("Signup.html").include(req, resp);
     }
	}
	

}

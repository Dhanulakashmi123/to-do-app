package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.userdto;
import service.userservice;

@WebServlet("/signup")
public class File1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LocalDate dob = LocalDate.parse(req.getParameter("dob"));

      userdto dto=new userdto();
     dto.setDob(dob);
     dto.setEmail(req.getParameter("email"));
     dto.setGender(req.getParameter("gender"));
     dto.setName(req.getParameter("name"));
     dto.setPassword(req.getParameter("password"));
     dto.setAge( LocalDate.now().getYear() - dob.getYear());
     
     userservice service=new userservice();
     if(service.saveuser(dto))
     {
    	 resp.getWriter().print("<h1 style='color:blue'>account created sucess</h1>");
    	 req.getRequestDispatcher("Login.html").include(req, resp);
     }
     else
     {
    	 resp.getWriter().print("<h1 style='color:blue'>sorry!! account canot be created</h1>") ; 
    	 req.getRequestDispatcher("Signup.html").include(req, resp);
     }
     
      
	}

}

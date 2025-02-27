package ckee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Cookieexample")
public class Cookieexample extends HttpServlet {

    

	
	protected void doGet(HttpServletRequest reqst, HttpServletResponse respns) throws ServletException, IOException {
		
		respns.setContentType("text/html");
		
		PrintWriter pobject = respns.getWriter();
		
		Cookie ck1 = new Cookie(reqst.getParameter("ckdt"),"shubhamph3");
		
		
		
		ck1.setMaxAge(60*5);
		
		respns.addCookie(ck1);
		
		
		
		pobject.println("<h3>New Cookie is set</h3>");
		
		pobject.println("<a href='readcke'>Read ck</a>");
		
		
		
	}

	
	

}

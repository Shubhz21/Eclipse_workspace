package mypkg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/stdList")

public class Studentlistsrvlt extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ArrayList<String> std = new ArrayList<>();
		
		std.add("Shubham");
		std.add("Viraj");
		std.add("Kalyani");
		std.add("Rushikesh");
		std.add(0, "Om");
		
		req.setAttribute("stdList", std);
		
		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
		
		rd.forward(req,res);
		
		
	}

}

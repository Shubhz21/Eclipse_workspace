package mypknew;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/Dashbrdsrvlt")

public class Verify implements Filter {

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession s = req.getSession(false);
		
		String path = req.getServletPath();
		
        if (path.equals("/Dashbrdsrvlt") || path.equals("/login.html")) {
            chain.doFilter(request, response);
            return;
        }
		
		if (s == null || s.getAttribute("username") == null) {
            res.sendRedirect("login.html");  
            return; 
        }
		
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {}

    public void destroy() {}

}

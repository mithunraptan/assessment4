package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.config.SpringConfig;
import com.training.service.UserService;

/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/customerLogin")
public class CustomerLoginServlet extends HttpServlet {
	  private UserService userService;

	    @Override
	    public void init() throws ServletException {

	        // Start Spring container
	        ApplicationContext context =
	                new AnnotationConfigApplicationContext(SpringConfig.class);

	        userService = context.getBean(UserService.class);
	    }

	    protected void doPost(HttpServletRequest request,
	                          HttpServletResponse response)
	            throws ServletException, IOException {

	        String username = request.getParameter("userName").trim();
	        String password = request.getParameter("password").trim();

	        boolean valid = userService.customerValidateLogin(username, password);

	        if (valid) {
//	            response.getWriter().println("customer Login Successful (Servlet + Hibernate + Spring)");
	        	HttpSession session = request.getSession();
	        	session.setAttribute("userName",username );
	            request.getRequestDispatcher("customer-login-successfull.jsp")
                .forward(request, response);
	            
	        } else {
	            request.setAttribute("errorMessage", "Invalid username or password");
	            request.getRequestDispatcher("customer-login.jsp")
	                   .forward(request, response);
	        }
	    }
}

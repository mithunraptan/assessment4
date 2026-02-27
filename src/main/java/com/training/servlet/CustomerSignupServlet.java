package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.config.SpringConfig;
import com.training.service.UserService;

/**
 * Servlet implementation class CustomerSignupServlet
 */
@WebServlet("/customerSignup")
public class CustomerSignupServlet extends HttpServlet {
	  private UserService userService;

	    @Override
	    public void init() throws ServletException {
	        ApplicationContext ctx =
	                new AnnotationConfigApplicationContext(SpringConfig.class);
	        userService = ctx.getBean(UserService.class);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        // THIS call will trigger JPAUtil → EMF → table creation
	        userService.registerUser(username, password);

	        response.sendRedirect("signup-success.jsp");
	    }

}

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
 * Servlet implementation class CustomerDeletePolicyServlet
 */
@WebServlet("/customerDeletePolicy")
public class CustomerDeletePolicyServlet extends HttpServlet {
	 private UserService userService;

	    @Override
	    public void init() throws ServletException {

	        // Start Spring container
	        ApplicationContext context =
	                new AnnotationConfigApplicationContext(SpringConfig.class);

	        userService = context.getBean(UserService.class);
	    }

	    @Override
	    protected void doGet(HttpServletRequest request,
	                         HttpServletResponse response)
	            throws ServletException, IOException {

	        long id = Long.parseLong(request.getParameter("id"));
//	        System.out.println(id);

	        userService.CustomerDeleteInsurancePolicy(id);

	        response.sendRedirect("customer-login-successfull.jsp");
	    }
}

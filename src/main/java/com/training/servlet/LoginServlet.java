package com.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.config.SpringConfig;
import com.training.service.UserService;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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

        boolean valid = userService.validateLogin(username, password);

        if (valid) {
//            response.getWriter().println("Login Successful (Servlet + Hibernate + Spring)");
        	response.sendRedirect("home.jsp");
            
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp")
                   .forward(request, response);
        }
    }
}
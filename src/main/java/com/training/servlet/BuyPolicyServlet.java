package com.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.config.SpringConfig;
import com.training.entity.InsurancePolicy;
import com.training.service.UserService;

/**
 * Servlet implementation class BuyPolicyServlet
 */
@WebServlet("/buyPolicy")
public class BuyPolicyServlet extends HttpServlet {
	 private UserService userService;

		
	    @Override
	    public void init() throws ServletException {

	        // Start Spring container
	        ApplicationContext context =
	                new AnnotationConfigApplicationContext(SpringConfig.class);

	        userService = context.getBean(UserService.class);
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			String idParam = request.getParameter("id");
			if (idParam != null) {
			    try {
			        int policyId = Integer.parseInt(idParam);
			        System.out.println("policy id is : "+ policyId);
			        // Process policyId
			    } catch (NumberFormatException e) {
			        // Handle invalid number
			    }
			    
			   userService.addPolicyToUser(idParam,request);
			    
			    
			    
//		       String policyName = request.getParameter("policyName").trim();		
//		       InsurancePolicy insurancePolicy = userService.findInsurancePolicy(policyName);
////		       System.out.println("printing policy name " + insurancePolicy.getPolicyName());
//		       request.setAttribute("insurancePolicy", insurancePolicy);
//		       if(insurancePolicy!=null) {
//		       request.getRequestDispatcher("policy-find-successfull-page.jsp")
//		        .forward(request, response);
//		       }
//		       else {
//			       request.getRequestDispatcher("policy-notfound-page.jsp")
//			        .forward(request, response);
//		       }
			}
			
		}
		

}

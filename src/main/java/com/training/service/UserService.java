package com.training.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.UserDAO;
import com.training.entity.Admin;
import com.training.entity.InsurancePolicy;
import com.training.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean validateLogin(String name, String password) {
//    	System.out.println("Spring Service Called");

        Admin admin = userDAO.findByNameAndPassword(name, password);

        return admin != null;
    }

	public void registerUser(String username, String password) {
		// TODO Auto-generated method stub
	    User user = new User();
	    user.setName(username);
	    user.setPassword(password);
	    user.setLisOfPolicy(null);
	    
	    userDAO.saveUser(user);
		
	}

	public void addInsurancePolicy(String policyName, String premiumMonth, String durationMonth) {
		// TODO Auto-generated method stub
		InsurancePolicy insurancePolicy = new InsurancePolicy();
		insurancePolicy.setPolicyName(policyName);
		insurancePolicy.setPremiumMonth(premiumMonth);
		insurancePolicy.setDurationMonth(durationMonth);
		
		userDAO.addInsurance(insurancePolicy);
		
	}

	public void deleteInsurancePolicy(String policyName) {
		// TODO Auto-generated method stub
		userDAO.deleteInsurance(policyName);
		
	}

	public InsurancePolicy findInsurancePolicy(String policyName) {
		// TODO Auto-generated method stub
		InsurancePolicy isp = userDAO.findInsurancePolicy(policyName);
		return isp;
		
	}

	public boolean customerValidateLogin(String username, String password) {
		// TODO Auto-generated method stub
        User user = userDAO.customerFindByNameAndPassword(username, password);

        return user != null;	
        }

	public void addPolicyToUser(String idParam, HttpServletRequest request) {
		// TODO Auto-generated method stub
		userDAO.addPolicyToUser(idParam, request);
		
	}

	public void CustomerDeleteInsurancePolicy(long id) {
		// TODO Auto-generated method stub
		userDAO.customerDeletePolicy(id);
		
	}


}
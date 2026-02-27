package com.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.training.entity.Admin;
import com.training.entity.InsurancePolicy;
import com.training.entity.User;
import com.training.util.JPAUtil;

@Repository
public class UserDAO {

    public Admin findByNameAndPassword(String name, String password) {
//    	System.out.println("Hibernate DAO Called");

        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "FROM Admin a WHERE a.name = :name AND a.password = :pwd",
                    Admin.class)
                    .setParameter("name", name)
                    .setParameter("pwd", password)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

	public void saveUser(User user) {
		// TODO Auto-generated method stub
	    EntityManager em = JPAUtil.getEntityManager();

	    em.getTransaction().begin();
	    em.persist(user);
	    em.getTransaction().commit();

	    em.close();
		
	}

	public void addInsurance(InsurancePolicy insurancePolicy) {
		// TODO Auto-generated method stub
	    EntityManager em = JPAUtil.getEntityManager();

	    em.getTransaction().begin();
	    em.persist(insurancePolicy);
	    em.getTransaction().commit();

	    em.close();
		
	}

	public void deleteInsurance(String policyName) {
		// TODO Auto-generated method stub
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            InsurancePolicy policyFound = em.createQuery( "FROM InsurancePolicy i WHERE i.policyName = :name",InsurancePolicy.class)
            .setParameter("name", policyName)
            .getSingleResult();
            if(policyFound!=null) {
            	em.getTransaction().begin();;
            	em.remove(policyFound);
            	em.getTransaction().commit();
            	System.out.println("policy deleted successfully!!");
            	
            }

        } catch (NoResultException e) {
          
        } finally {
            em.close();
        }

		
	}

	public InsurancePolicy findInsurancePolicy(String policyName) {
		// TODO Auto-generated method stub
        EntityManager em = JPAUtil.getEntityManager();

		List<InsurancePolicy> resultList = em.createQuery( "FROM InsurancePolicy i WHERE i.policyName = :name",InsurancePolicy.class)
		            .setParameter("name", policyName).getResultList();
		if(!resultList.isEmpty()) {
			InsurancePolicy insurancePolicy = resultList.get(0);
			return insurancePolicy;
		}
		else {
			return null;
		}
		            

	
		
		
	}

	public User customerFindByNameAndPassword(String username, String password) {
		 EntityManager em = JPAUtil.getEntityManager();

	        try {
	            return em.createQuery(
	                    "FROM User u WHERE u.name = :name AND u.password = :pwd",
	                    User.class)
	                    .setParameter("name", username)
	                    .setParameter("pwd", password)
	                    .getSingleResult();

	        } catch (NoResultException e) {
	            return null;
	        } finally {
	            em.close();
	        }
	}

	public void addPolicyToUser(String idParam, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String name =(String)request.getAttribute("userName");
		 EntityManager em = JPAUtil.getEntityManager();
		 List<User> users = em.createQuery("FROM User u WHERE u.name = :name",
                 User.class).setParameter("name", name).getResultList();
		 long uId=0;
		 if(!users.isEmpty()) {
			 User user = users.get(0);
			 uId = user.getId();
		 }
		 
		 User userRef = em.getReference(User.class, uId);
		 

		 em.getTransaction().begin();;
		 em.createQuery("UPDATE InsurancePolicy e SET e.user = :newValue WHERE e.id = :id", InsurancePolicy.class)
		 .setParameter("newValue", userRef)
		 .setParameter("id", idParam);
		 em.getTransaction().commit();
		 System.out.println("policy added to particular user successfully");
		 
		 
		
		
		
		
		
	}
}

package com.training.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("LoginPU");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

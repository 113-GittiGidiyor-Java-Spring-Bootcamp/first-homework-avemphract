package dev.patika.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsuranceApiClient {
    static EntityManagerFactory emf=null;

    public static EntityManager getEntityManager(String persistenceUnitName){
        emf= Persistence.createEntityManagerFactory(persistenceUnitName);
        return emf.createEntityManager();
    }

    public static void cleanEntityManager(EntityManager em){
        em.clear();
        em.close();
        emf.close();
    }
}
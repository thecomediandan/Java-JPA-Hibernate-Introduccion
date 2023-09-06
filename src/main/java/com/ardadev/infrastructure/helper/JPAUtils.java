package com.ardadev.infrastructure.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("empresaPersistence");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}

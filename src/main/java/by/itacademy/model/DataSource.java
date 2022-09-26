package by.itacademy.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;

public class DataSource {
    private static final DataSource dataSource = new DataSource();

    private static EntityManagerFactory entityManagerFactory;

    private DataSource() {
        entityManagerFactory = Persistence.createEntityManagerFactory("by.task4");
    }

    public static DataSource getInstance() {
        return dataSource;
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }
}

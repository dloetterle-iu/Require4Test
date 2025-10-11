package require4test.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class EntityManagementService {

    private static final EntityManager entityManager = Persistence.createEntityManagerFactory("default")
            .createEntityManager();

    public void persist(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void update(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void remove(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}

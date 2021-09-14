package com.training.spring.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.training.spring.model.Person;

@Repository
public class MyPersonDao {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public void add(final Person person) {
        EntityManager em = this.emf.createEntityManager();
        em.joinTransaction();

        em.find(null,
                em,
                LockModeType.OPTIMISTIC_FORCE_INCREMENT);

        em.lock(em,
                null);

        em.getTransaction()
          .begin();
        try {
            em.persist(person);
            em.getTransaction()
              .commit();
            em.detach(person);

            if (em.contains(person)) {
                // MANAGED
            } else {
                Person mergeLoc = em.merge(person);
                mergeLoc.getPhones();
                // DETACH
            }
        } catch (Exception eLoc) {
            em.getTransaction()
              .rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}

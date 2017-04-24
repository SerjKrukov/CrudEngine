package com.engine.rides.logic;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Serj on 23.04.2017.
 */
@Repository
@Transactional
public class TrailDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public void addTrail(Trail trail) {
        entityManager.persist(trail);
    }

    @SuppressWarnings("unchecked")
    public List<Trail> getAllTrails() {
        return entityManager.createQuery("from TRAILS").getResultList();
    }

    public Trail getTrailById(long id) {
        return entityManager.find(Trail.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Trail> getTrailsByCriteria(String title, String region, String date) {
        return entityManager.createQuery("from TRAILS where TITLE LIKE :title AND REGION LIKE :region AND DATE LIKE :date")
                .setParameter("title", title + "%")
                .setParameter("region", region + "%")
                .setParameter("date", date + "%")
                .getResultList();
    }

    public void updateTrail(Trail trail) {
        entityManager.merge(trail);
    }

    public void deleteTrail(Trail trail) {
        entityManager.remove(trail);
    }
}

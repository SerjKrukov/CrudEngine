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
public class RiderProfileDAO {
    @PersistenceContext
    private EntityManager entityManager;


    public void addRP(RiderProfile riderProfile) {
        entityManager.persist(riderProfile);
    }

    public RiderProfile getRPbyId(long id) {
        return entityManager.find(RiderProfile.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<RiderProfile> getRPbyCriteria(String name, String nickname) {
        return entityManager.createQuery("form RIDER_PROFILES where NAME LIKE :name AND NICKNAME LIKE :nickname")
                .setParameter("name",name + "%").setParameter("nickname",nickname + "%").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<RiderProfile> getAllRP() {
        return entityManager.createQuery("from RIDER_PROFILES").getResultList();
    }

    public void updateRP(RiderProfile riderProfile) {
        entityManager.merge(riderProfile);
    }

    public void removeRP(RiderProfile riderProfile) {
        entityManager.remove(riderProfile);
    }
}

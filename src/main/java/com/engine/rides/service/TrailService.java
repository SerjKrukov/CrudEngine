package com.engine.rides.service;

import com.engine.rides.logic.Trail;
import com.engine.rides.logic.TrailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Serj on 23.04.2017.
 */
@Transactional
@Service
public class TrailService {

    @Autowired
    private TrailDAO trailDAO;

    public void addTrail(Trail trail) {
        trailDAO.addTrail(trail);
    }

    public Trail getById(long id) {
        return trailDAO.getTrailById(id);
    }

    public List<Trail> getAllTrails() {
        return trailDAO.getAllTrails();
    }

    public List<Trail> getByCriteria(String title, String region, String date) {
        return trailDAO.getTrailsByCriteria(title, region, date);
    }

    public void updateTrail(Trail trail) {
        trailDAO.updateTrail(trail);
    }

    public void deleteTrail(Trail trail) {
        trailDAO.deleteTrail(trail);
    }
}

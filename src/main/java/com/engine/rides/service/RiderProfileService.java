package com.engine.rides.service;

import com.engine.rides.logic.RiderProfile;
import com.engine.rides.logic.RiderProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Serj on 23.04.2017.
 */
@Service
@Transactional
public class RiderProfileService {

    @Autowired
    RiderProfileDAO riderProfileDAO;

    public void addRP(RiderProfile riderProfile) {
        riderProfileDAO.addRP(riderProfile);
    }

    public RiderProfile getRPbyId(long id) {
        return riderProfileDAO.getRPbyId(id);
    }

    public List<RiderProfile> getAllRP() {
        return riderProfileDAO.getAllRP();
    }

    public List<RiderProfile> getRPbyCriteria(String name, String nickname) {
        return riderProfileDAO.getRPbyCriteria(name, nickname);
    }

    public void updateRP(RiderProfile riderProfile) {
        riderProfileDAO.updateRP(riderProfile);
    }

    public void removeRP(RiderProfile riderProfile) {
        riderProfileDAO.removeRP(riderProfile);
    }
}

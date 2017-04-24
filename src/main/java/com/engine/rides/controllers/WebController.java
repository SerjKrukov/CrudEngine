package com.engine.rides.controllers;

import com.engine.rides.logic.Trail;
import com.engine.rides.service.RiderProfileService;
import com.engine.rides.service.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Serj on 21.04.2017.
 */
@Controller
public class WebController {

    @Autowired
    private TrailService trailService;

    @Autowired
    private RiderProfileService riderProfileService;

    @ModelAttribute("allTrails")
    public List<Trail> getAllTrails() {
        return trailService.getAllTrails();
    }
    @RequestMapping(value = {"/", "/mainpage"}, method = RequestMethod.GET)
    public String mainMenu(ModelMap model) {
        return "mainpage";
    }
}

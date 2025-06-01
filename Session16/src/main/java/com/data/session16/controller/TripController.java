package com.data.session16.controller;

import com.data.session16.model.Trip;
import com.data.session16.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/home")
    public String homePage(Model model,
                           @RequestParam(required = false) String startPoint,
                           @RequestParam(required = false) String endPoint) {

        List<Trip> trips;

        if ((startPoint == null || startPoint.trim().isEmpty()) &&
                (endPoint == null || endPoint.trim().isEmpty())) {
            trips = tripService.getAllTrips();
        } else {
            trips = tripService.searchTripByStartAndEndPoint(startPoint, endPoint);
        }

        model.addAttribute("trips", trips);
        model.addAttribute("startPoint", startPoint);
        model.addAttribute("endPoint", endPoint);
        return "home";
    }


}

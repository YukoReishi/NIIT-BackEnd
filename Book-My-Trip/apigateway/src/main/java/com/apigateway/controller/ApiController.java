package com.apigateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiController {
    @GetMapping("/clientServiceFallback")
    public String clientServiceFallback() {
        return "Client service is down at this time !!";
    }

    @GetMapping("/busServiceFallback")
    public String busServiceFallback() {
        return "/Bus service is down at this time";
    }

    @GetMapping("/trainServiceFallback")
    public String trainServiceFallback() {
        return "Train service is down at this time !!";
    }

    @GetMapping("/flightServiceFallback")
    public String flightServiceFallback() {
        return "Flight service is down at this time";
    }

    @GetMapping("/hotelServiceFallback")
    public String hotelServiceFallback() {
        return "Hotel service is down at this time";
    }
}

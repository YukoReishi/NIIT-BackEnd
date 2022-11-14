package com.bookMyTrip.controller;

import com.bookMyTrip.model.User;
import com.bookMyTrip.repository.UserRepo;
import com.bookMyTrip.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/BookMyTrip")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepo userRepo;

    int status=0;
    User user;
    Long userID;

    @GetMapping("/landingPage")
    public String landingPage(){
        return "LandingPage";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "UserLogin";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "UserRegister";
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@ModelAttribute User user, BindingResult bindingResult, ModelMap modelMap){
        try{
            String message = userService.verify(user.getUserId(),user.getPassword());
            Optional<User> users = Optional.ofNullable(userRepo.findById(user.getUserId()).orElse(null));
            if(users.isPresent()){
                userID=users.get().getUserId();
                user=users.get();
                status=1;
                modelMap.addAttribute("list",user);
            }
            return new ModelAndView("ServicePage",modelMap);
        }catch (Exception e){
            modelMap.addAttribute("message",e.getMessage());
            return new ModelAndView("UserLogin",modelMap);
        }
    }


    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute User user, BindingResult bindingResult, ModelMap modelMap){
        try{
            String message = userService.registerCustomer(user);
            modelMap.addAttribute("message",message);
        }catch (Exception e){
            modelMap.addAttribute("message",e.getMessage());
        }
        return new ModelAndView("UserRegister",modelMap);
    }


    @GetMapping("/trains")
    public ModelAndView trainService(ModelMap modelMap){
        modelMap.addAttribute("message","This is Train Service");
        return new ModelAndView("TrainService",modelMap);
    }

    @GetMapping("/flights")
    public ModelAndView flightService(ModelMap modelMap){
        modelMap.addAttribute("message","This is Flight Service");
        return new ModelAndView("FlightService",modelMap);
    }

    @GetMapping("/buses")
    public ModelAndView busService(ModelMap modelMap){
        modelMap.addAttribute("message","This is Buses Service");
        return new ModelAndView("BusService",modelMap);
    }

    @GetMapping("/hotels")
    public ModelAndView hotelService(ModelMap modelMap){
        modelMap.addAttribute("message","This is Hotels Service");
        return new ModelAndView("HotelService",modelMap);
    }


    @PostMapping("/hotels")
    public ModelAndView findHotels(@RequestParam String city,ModelMap modelMap){
        List hotels = restTemplate.getForObject("https://hotel-service/hotel/"+city,List.class);
        modelMap.addAttribute("hotels",hotels);
        return new ModelAndView("other",modelMap);
    }

    @PostMapping("/trains")
    public ModelAndView findTrains(@RequestParam String from,@RequestParam String to,@RequestParam String classType,ModelMap modelMap,HttpServletRequest request){
        List trains = restTemplate.getForObject("https://train-service/trains/viewsorted/"+from+"/"+to+"/"+classType,List.class);
        List hotels = restTemplate.getForObject("https://hotel-service/hotel/"+to,List.class);
        modelMap.addAttribute("city",to);
        modelMap.addAttribute("hotels",hotels);
        modelMap.addAttribute("trains",trains);
        request.setAttribute("mode","TRAINS");
        return new ModelAndView("other",modelMap);
    }

    @PostMapping("/buses")
    public ModelAndView findBuses(@RequestParam String from, @RequestParam String to, @RequestParam String classType, ModelMap modelMap, HttpServletRequest request){
        List buses = restTemplate.getForObject("https://bus-service/bus/viewsorted/"+from+"/"+to+"/"+classType,List.class);
        List hotels = restTemplate.getForObject("https://hotel-service/hotel/"+to,List.class);
        modelMap.addAttribute("city",to);
        modelMap.addAttribute("hotels",hotels);
        modelMap.addAttribute("buses",buses);
        request.setAttribute("mode","BUSES");
        return new ModelAndView("other",modelMap);
    }

    @PostMapping("/flights")
    public ModelAndView findFlights(@RequestParam String from,@RequestParam String to,@RequestParam String classType,ModelMap modelMap,HttpServletRequest request){
        List flights = restTemplate.getForObject("https://flight-service/flight/viewsorted/"+from+"/"+to+"/"+classType,List.class);
        List hotels = restTemplate.getForObject("https://hotel-service/hotel/"+to,List.class);
        modelMap.addAttribute("city",to);
        modelMap.addAttribute("hotels",hotels);
        modelMap.addAttribute("flights",flights);
        request.setAttribute("mode","FLIGHTS");
        return new ModelAndView("other",modelMap);
    }
}

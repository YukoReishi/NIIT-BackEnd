package com.user.controller;


import com.user.model.User;
import com.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public ModelAndView getUser(@PathVariable("userId") Long userId, ModelMap modelMap){

        Optional<User> user = Optional.ofNullable(iUserService.getUser(userId));
        List contacts = restTemplate.getForObject("https://contact-service/contact/"+user.get().getUserId(),List.class);
        HashMap hashMap = (HashMap) contacts.get(0);
        user.get().setContacts(contacts);
//        System.out.println(hashMap.get("email"));
        modelMap.addAttribute("list",user.get());

        return new ModelAndView("Display",modelMap);
    }
}

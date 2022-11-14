package com.contacts.controller;

import com.contacts.model.Contacts;
import com.contacts.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping("/{userId}")
    public List<Contacts> getContacts(@PathVariable("userId") Long userId){
        return this.contactService.getContactOfUser(userId);
    }
}

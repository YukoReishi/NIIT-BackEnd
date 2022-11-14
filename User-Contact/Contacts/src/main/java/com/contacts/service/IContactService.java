package com.contacts.service;

import com.contacts.model.Contacts;

import java.util.List;


public interface IContactService {

    public List<Contacts> getContactOfUser(Long userId);
}

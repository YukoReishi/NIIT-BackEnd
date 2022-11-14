package com.contacts.service;

import com.contacts.model.Contacts;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ContactServiceImpl implements com.contacts.service.IContactService {

    List<com.contacts.model.Contacts> list = List.of(
            new Contacts(1L,"vishal1810051@gmail.com","6398222157","Secunderabad",101L),
            new Contacts(2L,"vikash123@gmial.com","8789565423","Delhi",102L),
            new Contacts(3L, "akash123@gmail.com","6789876432","Mumbai", 103L),
            new Contacts(4L, "sandeep123@gmail.com","9995674323","Ghaziabad", 104L)
    );

    @Override
    public List<Contacts> getContactOfUser(Long userId) {
        return list.stream().filter(contacts -> contacts.getUserId().equals(userId)).collect(Collectors.toList());
    }
}

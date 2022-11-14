package com.kafkapublisher.service;

import com.kafkapublisher.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaService {

    List<User> list = List.of(
            new User (101L, "Vishal",8767654543,"Secunderabad"),
            new User (102L, "Sandeep",1123434543,"Mumbai"),
            new User (103L, "Mohit",8976565453,"Delhi")
    );

    public User getUser(Long id) {
        return list.stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);
    }
}

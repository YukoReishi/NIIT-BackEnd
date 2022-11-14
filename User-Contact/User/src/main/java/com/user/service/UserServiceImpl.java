package com.user.service;


import com.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService{

    List<User> list = List.of(
            new User(101L, "Vishal Gupta","21"),
            new User(102L, "Vikash Kumar","22"),
            new User(103L, "Aakash Kumar","23"),
            new User(104L, "Sandeep","24")
    );
    @Override
    public User getUser(Long userId) {
        return list.stream().filter(user->user.getUserId().equals(userId)).findAny().orElse(null);
    }
}

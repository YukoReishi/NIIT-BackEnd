package com.bookMyTrip.service;

import com.bookMyTrip.model.User;


public interface IUserService {

    public String registerCustomer(User user) throws Exception;
    public String verify(Long userId,String password) throws Exception;
    public String updateCustomer(User user, Long id);
}

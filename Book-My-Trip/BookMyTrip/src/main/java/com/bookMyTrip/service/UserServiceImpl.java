package com.bookMyTrip.service;

import com.bookMyTrip.model.User;
import com.bookMyTrip.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Component
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public String registerCustomer(User user) throws Exception {
        if(user.getUserName().equals("") || user.getUserName().equals(null)){
            throw new Exception("Fill User Name");
        }else if(user.getPassword().equals("") || user.getPassword().equals(null)){
            throw new Exception("Fill Password");
        } else if (user.getPassword().length()<6) {
            throw new Exception("Password Length should be 6 or more");
        }else if(user.getUserAge().equals("") || user.getUserAge().equals(null)){
            throw new Exception("Fill Age");
        } else if(user.getUserGender().equals("") || user.getUserGender().equals(null)) {
            throw new Exception("Fill Gender");
        } else if (!(user.getUserMobile().length()==10)) {
            throw new Exception("Enter Correct Mobile No");
        } else if (user.getUserAddress().equals("") || user.getUserAddress().equals(null)) {
            throw new Exception("Fill Address");
        }else{
            Long userId = userRepo.save(user).getUserId();
            return "Registered Successfully with Customer Id "+ userId;
        }
    }

    @Override
    public String updateCustomer(User user,Long id){
        if(user.getPassword().equals("") || user.getPassword().equals(null)){
            return "Fill Password";
        } else if (user.getPassword().length()<6) {
            return "Password Length should be 6 or more";
        }else {

            user.setUserId(id);
            userRepo.save(user);
            System.out.println(id);
            return "Updated Successfully !";
        }
    }

    @Override
    public String verify(Long userId,String password) throws Exception {
        if(userId.equals("") || userId.equals(null)){
            throw new Exception("Fill UserId");
        } else if (password.equals(null) || password.equals("")) {
            throw new Exception("Fill Password");
        }

        if(userRepo.existsById(userId)){
            if(userRepo.findById(userId).get().getPassword().equals(password)){
                return "verified";
            }else throw new Exception("Wrong Password");
        }else throw new Exception("Invalid User");
    }
}

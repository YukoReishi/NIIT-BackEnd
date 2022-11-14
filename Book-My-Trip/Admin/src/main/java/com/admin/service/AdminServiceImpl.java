package com.admin.service;

import com.admin.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Override
    public String adminLogin(String userId, String password) throws Exception {
        if(adminRepo.findByUserIdAndPassword(userId,password).isEmpty()){
            throw new Exception("Something Went Wrong!");
        }
        else{
            return "verified";
        }
    }
}

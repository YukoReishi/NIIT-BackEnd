package com.admin.repository;

import com.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
    List<Admin> findByUserIdAndPassword(String userId,String password);
}

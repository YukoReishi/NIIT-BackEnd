package com.admin.controller;

import com.admin.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/admin")
    public ModelAndView adminLogin(@)
}

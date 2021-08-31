package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.SignupForm;
import com.example.service.SignupFormService;

@Controller
@RequestMapping("/user")
public class UserListController {

	@Autowired
	private SignupFormService signupFormService;
	
    @GetMapping("/list")
    public String getUserList(Model model){
    	Iterable<SignupForm> userList1 = signupFormService.findAll();
    	model.addAttribute("userList", userList1);
        return "user/list";
    }
}
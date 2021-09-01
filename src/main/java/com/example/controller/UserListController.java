package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.User;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserListController {

	@Autowired
	private UserService userService;
	
    @GetMapping("/list")
    public String findAll(@ModelAttribute User user, Model model) {
    	Iterable<User> userList = userService.findAll();
    	model.addAttribute("userList", userList);
        return "user/list";
    }
    
    @PostMapping("list")
    public String findByUserNameIgnoreCaseStartingWithOrAge(@ModelAttribute User user, Model model) {
    	Iterable<User> userList = userService.findByUserNameIgnoreCaseStartingWithOrAge(user.getUserName(), user.getAge());
    	model.addAttribute("userList", userList);
    	return "user/list";
    }
}
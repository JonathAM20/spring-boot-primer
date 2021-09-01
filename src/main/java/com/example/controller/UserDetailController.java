package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.User;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserDetailController {
	
	@Autowired
	private UserService signupFormService;

	@GetMapping("/detail/{userId:.+}")
	public String findById(Model model, @PathVariable("userId") String email) {
		User user = signupFormService.findById(email);
		model.addAttribute("user", user);
		return "user/detail";
	}
	
	@PostMapping(value="/detail", params="update")
	public String update(User form, Model model) {
		try {
			User signupForm = signupFormService.findById(form.getUserId());
			signupForm.setUserName(form.getUserName());
			signupFormService.save(signupForm);	
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(form);	
		}
		return "redirect:/user/list";
	}
	
	@PostMapping(value="/detail", params="delete")
	public String delete(User form, Model model) {
		signupFormService.delete(form.getUserId());
		return "redirect:/user/list";
	}
}
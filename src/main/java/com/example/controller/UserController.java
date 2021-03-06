package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import com.example.service.UserApplicationService;
import com.example.service.ValidationGroupOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserApplicationService userApplicationService;
    
    @Autowired
    private UserService signupService;

    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale, @ModelAttribute User form){
        Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);
        return "user/signup";
    }

    @PostMapping("/signup")
    public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(ValidationGroupOrderService.class) User form, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return getSignup(model, locale, form);
        log.info(form.toString());
        System.out.println(form.toString());
        signupService.save(form);
        return "redirect:/login";
    }
}
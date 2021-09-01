package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void save(User signupForm) {
		userRepository.save(signupForm);
	}
	
	public void update(User signupForm) {
		userRepository.saveAndFlush(signupForm);
	}
	
	public void delete(String email) {
		userRepository.deleteById(email);
	}
	
	public Iterable<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String email){
		return userRepository. findById(email).get();
	}
	
	public Iterable<User> findByUserNameIgnoreCaseStartingWithOrAge(String userName, Integer age) {
		return userRepository.findByUserNameIgnoreCaseStartingWithOrAge(userName, age);
	}
}

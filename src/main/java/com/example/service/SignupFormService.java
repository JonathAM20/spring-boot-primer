package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.SignupForm;
import com.example.repository.SignupRepository;

@Service
public class SignupFormService {
	
	@Autowired
	private SignupRepository signupRepository;

	public void save(SignupForm signupForm) {
		signupRepository.save(signupForm);
	}
	
	public void update(SignupForm signupForm) {
		signupRepository.saveAndFlush(signupForm);
	}
	
	public void delete(String email) {
		signupRepository.deleteById(email);
	}
	
	public Iterable<SignupForm> findAll(){
		return signupRepository.findAll();
	}
	
	public SignupForm findById(String email){
		return signupRepository. findById(email).get();
	}
}

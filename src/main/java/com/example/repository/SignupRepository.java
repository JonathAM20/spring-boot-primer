package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.SignupForm;

public interface SignupRepository extends JpaRepository<SignupForm, String> {

}
package com.example.service;

import com.example.model.Employee;
import com.example.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public Employee save(){
        Employee employee = new Employee();
        employee.setName("Jonathan");
        employee.setAge(30);
        return helloRepository.save(employee);
    }
}
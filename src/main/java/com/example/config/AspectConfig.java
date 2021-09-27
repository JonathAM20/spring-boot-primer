package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AspectConfig {

	@Before("execution(* *..*.*UserService.*(..))")
	public void startBeforeLog(JoinPoint jp) {
		log.info("Method start: " + jp.getSignature());
	}
	
//	@Around("bean(*Controller)")
//	@Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	@Around("@within(org.springframework.stereotype.Controller)")
	public Object startEndAroundLog(ProceedingJoinPoint jp) throws Throwable {
		log.info("Method start: " + jp.getSignature());
		try {
			Object result = jp.proceed();
			log.info("Method end: " + jp.getSignature());
			return result;
		}catch(Exception ex) {
			log.info("Method end: " + jp.getSignature());
			throw ex;
		}
	}
	
	@After("execution(* *..*.*UserService.*(..))")
	public void endAfterLog(JoinPoint jp) {
		log.info("Method end: " + jp.getSignature());
	}
}
package com.gang.home.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class Card {

	@Around("execution(* com.gang.home.aop.test.Transport.take*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("삐삐삑");
		Object obj = joinPoint.proceed();
		log.info("비삐삑 하차입니다");
		return obj;
	}
}

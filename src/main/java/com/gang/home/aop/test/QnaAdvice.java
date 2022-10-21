package com.gang.home.aop.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.gang.home.board.qna.QnaVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class QnaAdvice {
	
	@After("execution(* com.gang.home.board.qna.QnaService.get*(..))")
	public void beforeTest(JoinPoint joinPoint) {
		log.info("-------------before---------------");
		log.info("Args:{}",joinPoint.getArgs());
		log.info("Target : {}", joinPoint.getKind());
	}

	@Around("execution(* com.gang.home.board.qna.QnaService.set*(..))")
	public Object aroundTest(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("--------------------before-------------------");
		//point-cut의 클래스 객체
		log.info("Target : {}",joinPoint.getTarget());
		//point-cut의 클래스 객체
		log.info("This : {}",joinPoint.getThis());
		//point-cut 으로 전달되는 매개변수의 인자값
		log.info("Args : {}",joinPoint.getArgs());
		Object[] objs = joinPoint.getArgs();
		QnaVO qnaVO =(QnaVO) objs[0]; //다형성
		
		
		Object obj = joinPoint.proceed();
		log.info("--------------------after---------------------");
		log.info("obj : {}",obj);
		return obj;
	}
}

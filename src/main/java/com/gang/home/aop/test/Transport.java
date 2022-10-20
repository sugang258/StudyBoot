package com.gang.home.aop.test;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Transport {
	
	public void takebus() {
		log.info("=====버스======");
	}
	
	public void takesubway() {
		log.info("======지하철=====");
	}
	public void gettaxi() {
		log.info("=======택시=====");
	}
	public void airplane() {
		log.info("========비행기=======");
	}

}

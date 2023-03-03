package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;

import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@Slf4j
public class JpaAppTest {
	 
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepositoryImpl userRepo;
	
	@BeforeEach
	void insertTestData() {
		
		for (int i=1; i<10; i++) {
			Users u1 = new Users();
			u1.setUserNm("김철수" + i);
			userRepo.save(u1);
		}
	}
	
	@Test
	void findAllTest() {
		List<Users> uList = userRepo.findAll();
		for (Users u : uList) {
			log.info(u.getUserNm() + " id: " + u.getId());
		}
	}
	
	@Test
	void find2ByIdTest() {
		List<Users> uList = userRepo.findByIdOrderByIdDesc(7);
		for (Users u : uList) {
			log.info(u.getUserNm() + "id: " + u.getId());
		}
	}
	
	@Test
	void findByIdTest() {
		Users us = userRepo.selectSQLById(4);
		log.info(us.getUserNm() + "id: " + us.getId());
	}
}

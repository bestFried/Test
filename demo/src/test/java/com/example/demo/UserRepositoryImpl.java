package com.example.demo;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	//final JPAQueryFactory fff;
	  
	/* 
	@Autowired
	public UserRepositoryImpl(JPAQueryFactory qff) {
		this.qf = qff;
	}
	*/
	@Override
	public List<Users> findFirst2ByUserNmLikeOrderByIdDesc(String nm) {
		// TODO Auto-generated method stub
		List<Users> uList = null;
		return uList;
	}

	@Override
	public List<Users> findByIdOrderByIdDesc(long id) {
		// TODO Auto-generated method stub
		List<Users> uList = null;
		return uList;
	}

	@Override
	public Users selectSQLById(long id) {
		// TODO Auto-generated method stub
		Users us = new Users();
		return us;
	}

	public void save(Users u1) {
		
		Users us = new Users();
		// TODO Auto-generated method stub
		
	}

	public List<Users> findAll() {
		
		
		return null;
	}

}

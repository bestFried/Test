package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//public interface UserRepository extends JpaRepository<Users, Long>{
public interface UserRepository{
	List<Users> findFirst2ByUserNmLikeOrderByIdDesc(String nm);
	List<Users> findByIdOrderByIdDesc(long id);
	 
	@Query(value="select user_nm, id from users us where us.id = :id ", nativeQuery = true)
	Users selectSQLById(@Param(value ="id") long id);
}

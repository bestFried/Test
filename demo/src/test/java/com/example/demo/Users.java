package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {
 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userNm;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id2) {
		id = id2;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	@Override
	public String toString() {
		return "ID : " + id + ", Name : " + userNm;
	}
	
}

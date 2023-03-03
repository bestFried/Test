package com.example.demo;

import lombok.Getter;
import lombok.Setter;

public class RestUsers {
	private final Long seq;
	private String name; 
	private String post; 
	private int postCnt;  
	
	public RestUsers (Long seq, String name, String post, int postCnt) {
		this.seq = seq;
		this.name = name; 
		this.post = post;
		this.postCnt = postCnt;
	}
	
	public void afterPosted() {
		postCnt++;
	}
	 
	public Long getSeq() {
		return seq;
	}
	
	public String getName() {
	    return name;
	}
	public String getPost() {
		return post;
	}
	public int getPostCnt() {
		return postCnt;
	}
	
	static public class Builder {
	    private Long seq;
	    private String name;
	    private String post;
	    private int postCnt; 
	    
	    public Builder() {/*empty*/}

	    public Builder(RestUsers user) {
	    	this.seq = seq;
			this.name = name; 
			this.post = post;
			this.postCnt = postCnt;
	    }

	    public Builder seq(Long seq) {
	      this.seq = seq;
	      return this;
	    }

	    public Builder name(String name) {
	      this.name = name;
	      return this;
	    }

	    public Builder post(String post) {
	      this.post = post;
	      return this;
	    }

	    public Builder postCnt(int postCnt) {
	      this.postCnt = postCnt;
	      return this;
	    }

	    public RestUsers build() {
	      return new RestUsers(seq, name, post, postCnt);
	    }
	  }
}

package com.example.demo;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoRestController {
	
	private static int cnt = 0;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping
	public ResponseEntity getReq (HttpServletRequest request) {
		
		ResponseEntity res = null;
		MultiValueMap< String, String> hd = new LinkedMultiValueMap<>();
		hd.add("content-type", "application/json;charset=utf-8");
		String cont = "";
		String msg = "";
		try {
			cont = "server check";
			msg = "{\"message\":\"" + cont + "\"}";
			res = new ResponseEntity<>(msg, hd, HttpStatus.OK);
			cnt ++;
		} catch (Exception e) {
			cont = "forbidden access!";
			msg = "{\"message\":\"" + cont + "\"}";
			res = new ResponseEntity<>(msg, hd, HttpStatus.FORBIDDEN);
			
		}
		
		return res;
	}

	@PostMapping(path = "post-test")
	public ResponseEntity<?> postTest(HttpServletRequest request) {
		
		//log.info(request.getParameter("userNm"));
		//log.info(request.getParameter("postNm"));
		
		
		
		TextUtil text = new TextUtil();
		text.Test(); //파일 생성
		text.propTest(); //파일 생성
		HashMap<String, Integer> map = new HashMap<>();
		
		
		//유저 게시글 저장. CRD 구현.. 
		ResponseEntity<?> res = null;
		MultiValueMap< String, String> hd = new LinkedMultiValueMap<>();
		hd.add("content-type", "application/json;charset=utf-8");
		String cont = "";
		String msg = "";
		try {
			msg = "{\"sum\":" + cnt +"}";
			res = new ResponseEntity<>(msg, hd, HttpStatus.OK);
			
		} catch (Exception e) {
			cont = "forbidden access!";
			msg = "{\"message\":\"" + cont + "\"}";
			res = new ResponseEntity<>(msg, hd, HttpStatus.FORBIDDEN);
			
		}

		return res;
	}
}

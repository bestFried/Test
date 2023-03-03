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
	private String testFile =  "C:\\chae_tmp\\worspace_test\\Test.txt";
	
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
		
		TextUtil tUtil = new TextUtil();
		ResponseEntity<?> res = null;
		MultiValueMap< String, String> hd = new LinkedMultiValueMap<>();
		hd.add("content-type", "application/json;charset=utf-8");
		String cont = "";
		String msg = "";
		
		try {
		
			//IP 검사
			tUtil.getUserIp(request);
		//log.info(request.getParameter("postNm"));
		String paramNm = request.getParameter("userNm");
		log.info(paramNm); //파리미터 이름
		
		tUtil.Test(testFile); //파일 생성
		tUtil.propTest(); //프로퍼티 파일 읽어보기.. 
		HashMap<String, Integer> map = new HashMap<>();
		//kim, park, lee, bae
		
		//걍 일단 다 넣어봄
		String[] names = {"kim", "park", "lee", "bae"};
		for (String n : names) {
			map.put(n, map.getOrDefault(n,0) + tUtil.returnValue(testFile, n).get(n));
		}
		
		//유저 게시글 저장. CRD 구현.. 
//			msg = "{\"sum\":" + cnt +"}";
			msg = "{\"sum\":" + map.get(paramNm) +"}";
			res = new ResponseEntity<>(msg, hd, HttpStatus.OK);
			
		} catch (Exception e) {
			cont = "forbidden access!";
			msg = "{\"message\":\"" + cont + "\"}";
			res = new ResponseEntity<>(msg, hd, HttpStatus.FORBIDDEN);
			
		}

		return res;
	}
}

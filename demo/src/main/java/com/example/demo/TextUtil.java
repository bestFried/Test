package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TextUtil {
	Logger log = LoggerFactory.getLogger(this.getClass());
	//String resource = "resources/info.properties";
	
    public void propTest() {
    	
        Properties prop = new Properties();
		String propFileName = "info.properties";
 
    	try {
    		InputStream is = getClass().getClassLoader().getResourceAsStream(propFileName);
    		if (is != null) {
    			prop.load(is);
    		} else {
    			log.info(" ======= 못 읽음 ======");
    		}
        log.info(prop.getProperty("user.name"));
        log.info(prop.getProperty("user.post"));
        log.info(prop.getProperty("user.postCnt"));

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
	public boolean Test (String filNm) {
		String filePath = filNm;
		boolean t = false;
		try {
			
	    File file = new File(filePath); // File객체 생성
	    if(!file.exists()){ // 파일이 존재하지 않으면
	         t = file.createNewFile(); // 신규생성
	    } else {
	    	file.delete();
	    	t = file.createNewFile(); // 신규생성
	    }

	    // BufferedWriter 생성
	    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

	    // 파일에 쓰기
	    writer.write("{\"kim\":34234}");
	    writer.newLine();
	    writer.write("{\"park\":433356}");
	    writer.newLine();
	    writer.write("{\"lee\":789}");
	    writer.newLine();
	    writer.write("{\"bae\":222}");
	    writer.newLine();

	    // 버퍼 및 스트림 뒷정리
	    writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
	    writer.close(); // 스트림 종료
		} catch (Exception e) {
			System.out.println("== 파일 익셉션 === " + e.getMessage());
		}
		return t;
	}
	
	//파일 테스트
	public HashMap<String, Integer> returnValue (String fileNm, String token) {
		HashMap<String, Integer> userCnt = new HashMap<>();
		try {
			BufferedReader reader = new BufferedReader(
				    new InputStreamReader(new FileInputStream(fileNm), "UTF-8"));
	        String str;
	        while ((str = reader.readLine()) != null) {
	        	if (str.indexOf(token+"\":") >= 0) {
	        		//System.out.println(str);
	        		String val = str.substring(str.indexOf(token+ "\":")+token.length()+2, str.length()-1);
	        		System.out.println(val);
	        		userCnt.put(token, Integer.parseInt(val) );
	        	}
	        }
		 
	        reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCnt;
	}
	
	
	//IP 
	public String getUserIp(HttpServletRequest request) throws Exception {
		
		 String ip = request.getHeader("X-Forwarded-For");
		 log.info("> X-FORWARDED-FOR : " + ip);

		 if (ip == null) {
		     ip = request.getHeader("Proxy-Client-IP");
		     log.info("> Proxy-Client-IP : " + ip);
		 }
		 if (ip == null) {
		     ip = request.getHeader("WL-Proxy-Client-IP");
		     log.info(">  WL-Proxy-Client-IP : " + ip);
		 }
		 if (ip == null) {
		     ip = request.getHeader("HTTP_CLIENT_IP");
		     log.info("> HTTP_CLIENT_IP : " + ip);
		 }
		 if (ip == null) {
		     ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		     log.info("> HTTP_X_FORWARDED_FOR : " + ip);
		 }
		 if (ip == null) {
		     ip = request.getRemoteAddr();
		     log.info("> getRemoteAddr : "+ip);
		 }
		 log.info("> Result : IP Address : "+ip);

		 return ip;
	}
	
}

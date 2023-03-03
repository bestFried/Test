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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    
	public boolean Test () {
		String filePath = "C:\\chae_tmp\\worspace_test\\Test.txt";
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
	    writer.write("{\"answer\":34234}");
	    writer.newLine();
	    writer.write("{\"answer\":433356}");
	    writer.newLine();
	    writer.write("{\"answer\":789}");
	    writer.newLine();
	    writer.write("{\"answer\":222}");
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
	public HashMap<String, Integer> returnValue (String fileNm) {
		HashMap<String, Integer> userCnt = new HashMap<>();
		try {
			BufferedReader reader = new BufferedReader(
				    new InputStreamReader(new FileInputStream(fileNm), "UTF-8"));
	        String str;
	        while ((str = reader.readLine()) != null) {
	        	if (str.indexOf("answer\":") >= 0) {
	        		//System.out.println(str);
	        		System.out.println(str.substring(str.indexOf("wer\":")+5, str.length()-1));
	        	}
	        }
		 
	        reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCnt;
	}
	
}

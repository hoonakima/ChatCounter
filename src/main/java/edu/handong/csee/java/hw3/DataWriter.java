package edu.handong.csee.java.hw3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataWriter {
	
	public void dataWriting(String filePath) { //파일 출력할 내용 input parameter에 추가
		
		String fileName = "result";
		fileName = filePath.concat(fileName);
		
		try {
			PrintWriter writer = new PrintWriter(fileName);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

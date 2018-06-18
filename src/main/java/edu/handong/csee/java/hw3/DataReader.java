package edu.handong.csee.java.hw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class DataReader {

	private String filePath; //input from CLI  "C:\\Users\\jo jeong hoon\\Desktop\\messages"
	
	private ArrayList<Data> dataListFromCsv = new ArrayList<Data>();
	private ArrayList<Data> dataListFromTxt = new ArrayList<Data>();
	
	
	public void readFiles(String filePath){ 
		
		this.filePath = filePath; //지워

		File dir = new File(filePath);

		File[] files = dir.listFiles();

		for(File file: files) {
			
			if(file.getName().endsWith(".csv")) {
				dataListFromCsv = DataReaderForCsv.gettingMessageFromCsvFiles(file);
//for check				System.out.println("file name: " + file.getName());
			}
			
			else if(file.getName().endsWith(".txt")) {
				dataListFromTxt = DataReaderForTxt.gettingMessageFromTxtFiles(file);
//for check				System.out.println("file name: " + file.getName());
				
			}
		}


	}
	
	public static void main(String[] args) {
		
		String filePath = "C:\\Users\\jo jeong hoon\\Desktop\\messages";
		DataReader reader = new DataReader();
		
		reader.readFiles(filePath);
	}
}

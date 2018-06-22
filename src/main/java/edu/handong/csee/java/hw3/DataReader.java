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
	
	private static ArrayList<Data> dataListFromCsv = new ArrayList<Data>();
	private static ArrayList<Data> dataListFromTxt = new ArrayList<Data>();
	
	
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
		RedundancyChecker checker = new RedundancyChecker();
		ArrayList<Data> csvDataList = new ArrayList<Data>();
		
		reader.readFiles(filePath);
		csvDataList = checker.finalCheckingRedundancy(dataListFromCsv, dataListFromTxt);
//		System.out.println("csv list: " + dataListFromCsv.size() + "txt list: " + dataListFromTxt.size());
//		System.out.println(csvDataList.size());
	}		
}

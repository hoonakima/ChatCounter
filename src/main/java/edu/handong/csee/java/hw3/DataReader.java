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
	
	private static ArrayList<Data> dataListFromCsv = new ArrayList<Data>();
	private static ArrayList<Data> dataListFromTxt = new ArrayList<Data>();
	private static ArrayList<Data> totalDataList = new ArrayList<Data>();
	
	
	public ArrayList<Data> readFiles(String filePath){ 
		
		DataReaderForCsv csvReader = new DataReaderForCsv();
		DataReaderForTxt txtReader = new DataReaderForTxt();

		File dir = new File(filePath);

		File[] files = dir.listFiles();
				
		for(File file: files) {
			
			
			if(file.getName().endsWith(".csv")) {
				dataListFromCsv = csvReader.gettingMessageFromFiles(file);

			}
			
			else if(file.getName().endsWith(".txt")) {
				dataListFromTxt = txtReader.gettingMessageFromFiles(file);

				
			}
		}
		
		totalDataList = RedundancyChecker.finalCheckingRedundancy(dataListFromCsv, dataListFromTxt);

		return totalDataList;
	}
		
}

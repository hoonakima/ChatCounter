package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.ColumnPositionMappingStrategy;

public class FileReaderForCsv {
	
	private File file = new File("C:\\Users\\jo jeong hoon\\Desktop\\messages\\JavaProgramming-L2.csv");     //get directory path from the Command Line

	public FileReaderForCsv() {
		
	}
	
	public List<Messages> readCsv(){
		
		List<Messages> data = null;
		
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			
			ColumnPositionMappingStrategy<Messages> start = new ColumnPositionMappingStrategy<Messages>();
			start.setType(Messages.class);
			String[] columns = new String[] {"time", "name", "message"};
			start.setColumnMapping(columns);
			
			CsvToBean<Messages> csv = new CsvToBean<Messages>();
			data = csv.parse(start, reader);
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return data;
	
	}

}

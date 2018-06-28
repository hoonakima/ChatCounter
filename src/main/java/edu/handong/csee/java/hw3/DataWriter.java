package edu.handong.csee.java.hw3;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DataWriter {
	
	public void dataWriting(String filePath, Map sortedEntry) { 
		
		String fileName = "result.csv";
		
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(filePath + "/" + fileName));
			
			Set set = sortedEntry.entrySet();
			Iterator iterator = set.iterator();
			
			while(iterator.hasNext()) {
				Map.Entry me = (Map.Entry)iterator.next();
				fw.write(me.getKey() + "," + me.getValue());
				fw.newLine();
			}
			
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		fw.write(d.getTime() + "," + d.getName() + "," + d.getMessage());
//		fw.newLine();
	}
	

}

package edu.handong.csee.java.hw3;

import java.util.ArrayList;

public class MessageCounter {

	public MyHashMap<String, Integer> countMessage(ArrayList<Data> dataList) {

		int count = 1;
		
		MyHashMap<String, Integer> studentEntry = new MyHashMap<String, Integer>();
		
		for(int i = 0; i < dataList.size() -1 ; i++) {
			
			count = 1;
			
			for(int j = i + 1 ; j < dataList.size(); j++) {
				
				if(dataList.get(i).getName().equals(dataList.get(j).getName())) {
					
					dataList.remove(j);
					count++;
					j--;
					
				}
				
			}
			
			studentEntry.put(dataList.get(i).getName(), count);
			
		}
		
		return studentEntry;
		
	}



}

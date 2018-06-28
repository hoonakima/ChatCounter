package edu.handong.csee.java.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class MyHashMap<String, Integer> extends HashMap<String, Integer>{
	
	String key;
	int value;
	
	MyHashMap(){
		key = null;
		value = 0;
	}
	
	MyHashMap(String n, int m){
		key = n;
		value = m;
	}
	
	public Map sortHashMapByValues(MyHashMap<String, Integer> studentEntry){
		
		Map<String, Integer> sortedMap = sortByValues(studentEntry);
		Set set = sortedMap.entrySet();
		Iterator iterator = set.iterator();
		
//		while(iterator.hasNext()) {
//			Map.Entry me = (Map.Entry)iterator.next();
//			System.out.print(me.getKey() + ": ");
//			System.out.println(me.getValue());
//		}
		
		return sortedMap;
		
	}
	private LinkedHashMap<String, Integer> sortByValues(MyHashMap<String, Integer> studentEntry) {
		List list = new LinkedList(studentEntry.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry)(o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
				
			}
		});
		
		LinkedHashMap sortedHashMap = new LinkedHashMap();
		for(Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedHashMap;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	

}

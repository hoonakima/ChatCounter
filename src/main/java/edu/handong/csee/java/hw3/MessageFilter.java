package edu.handong.csee.java.hw3;

import java.util.ArrayList;


public class MessageFilter {

	public MessageFilter() {

	}
}	
//	public ArrayList<Message> filtering(ArrayList<Message> dataListFromCsv, ArrayList<Message> dataListFromTxt) { 
//		
//		ArrayList<Message> scaledDataListFromCsv = new ArrayList<Message>();
//		ArrayList<Message> totalDataList = new ArrayList<Message>();
//		
//		scaledDataListFromCsv = MessageFilter.csvTimeDataScaling(dataListFromCsv);
//		
//		scaledDataListFromCsv.removeAll(dataListFromTxt);
//		
//		totalDataList.addAll(scaledDataListFromCsv);
//		totalDataList.addAll(dataListFromTxt);
//		
//		return totalDataList;
//	}
//	
//	public static ArrayList<Message> csvTimeDataScaling(ArrayList<Message> dataListFromCsv) {
//		
//		String timeDataFromCsv = null;
//		ArrayList<Message> scaledDataListFromCsv = new ArrayList<Message>();
//
//		for(Message dCsv : dataListFromCsv) {
//
//			String[] arr = (dCsv.getTime()).split(":"); //2018-02-28 18:31:09 > sec
//			
//			timeDataFromCsv = arr[0] + ":" + arr[1];
//			
//			dCsv.setTime(timeDataFromCsv);
//			scaledDataListFromCsv.add(dCsv);
//		}
//		
//		return scaledDataListFromCsv;
//	}


//	public static void main(String[] args) {
//		
//		DataReaderForCsv reader1 = new DataReaderForCsv();
//		DataReaderForTxt reader2 = new DataReaderForTxt();
//		
//		ArrayList<Message> dataListFromCsv = new ArrayList<Message>();
//		dataListFromCsv = reader1.dataReader();
//		
//		ArrayList<Message> dataListFromTxt = new ArrayList<Message>();
//		dataListFromTxt = reader2.dataReader();
//		
//		MessageFilter filter = new MessageFilter();
//		
//		ArrayList<Message> totalDataList = new ArrayList<Message>();
//		totalDataList = filter.csvTimeDataScaling(dataListFromCsv);
//	
//		System.out.println(totalDataList.size());
//	}
//
//}

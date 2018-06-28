package edu.handong.csee.java.hw3;

import java.util.ArrayList;

public class RedundancyChecker {


	public static ArrayList<Data> csvDataList = new ArrayList<Data>();
	public static ArrayList<Data> txtDataList = new ArrayList<Data>();
	public static ArrayList<Data> totalDataList = new ArrayList<Data>();

	public static ArrayList<Data> finalCheckingRedundancy(ArrayList<Data> dataListFromCsv, ArrayList<Data> dataListFromTxt){

		csvDataList = csvTimeDataScaling(dataListFromCsv);

		combineArrayList(csvDataList, txtDataList); 

		checkingRedundancy(totalDataList); 
		
		return totalDataList;

	}

	public static ArrayList<Data> checkingRedundancy(ArrayList<Data> dataList) {

		for(int i = 0; i < dataList.size() - 1 ; i++) {

			for(int j = i + 1 ; j < dataList.size(); j++) {
				if(dataList.get(i).getTime().equals(dataList.get(j).getTime()) && dataList.get(i).getName().equals(dataList.get(j).getName()) && dataList.get(i).getMessage().equals(dataList.get(j).getMessage())){

					dataList.remove(j);
					j--;

				}

			}
		}

		return dataList;
	}

	public static void combineArrayList(ArrayList<Data> csvDataList, ArrayList<Data> txtDataList){


		for(Data d1 : csvDataList) {
			totalDataList.add(d1);
		}
		for(Data d2 : txtDataList) {
			totalDataList.add(d2);
		}


	}

	public static ArrayList<Data> csvTimeDataScaling(ArrayList<Data> dataListFromCsv) {

		csvDataList = checkingRedundancy(dataListFromCsv);

		for(Data d : csvDataList) {
			String[] str = d.getTime().split(":");
			String time = str[0].concat(":" + str[1]);

			d.setTime(time);
		} 

		return csvDataList;

	}
	
//	public static ArrayList<Data> checkingPhotoRedundancy(ArrayList<Data> totalDataList){
//		
//		for(Data d : totalDataList) {
//			
//		}
//	}

}

package edu.handong.csee.java.hw3;

import java.util.ArrayList;

public class RedundancyChecker {

	
	public static ArrayList<Data> csvDataList = new ArrayList<Data>();
	public static ArrayList<Data> txtDataList = new ArrayList<Data>();
	public static ArrayList<Data> totalDataList = new ArrayList<Data>();

	public ArrayList<Data> finalCheckingRedundancy(ArrayList<Data> dataListFromCsv, ArrayList<Data> dataListFromTxt){
		
		csvDataList = checkingRedundancy(dataListFromCsv); //csv data끼리 Redundancy check하고
		txtDataList = checkingRedundancy(dataListFromTxt); //txt data끼리 Redundancy check하고
				
		combineArrayList(csvDataList, txtDataList); //csv data랑 txt data랑 하나의 dataList로 합쳐주면 끝
		
		for(Data d : totalDataList) { //각각 filtering된 csv data랑 txt data 합쳐진 것.
			System.out.println(d.getTime() + " " + d.getName() + " " + d.getMessage());
		}
		
		System.out.println("After checking redundancy size: " + totalDataList.size());

		return totalDataList;
	}

	public ArrayList<Data> checkingRedundancy(ArrayList<Data> dataList) {

		int count = 0;

		for(int i = 0; i < dataList.size(); i++) {
			
			if(i != (dataList.size() - 1)) {

				for(int j = i + 1; j < dataList.size(); j++) {
					if(dataList.get(i).getTime().equals(dataList.get(j).getTime())) {
						count++;			
					}
				}
				if(count > 0) {
					
					for(int k = 0; k < count; k++) { //k = 11
						dataList.remove(i + k); //i, i+1, i+10 까지 지움
						}
					
					count = 0;
				}
			}

		}
		return dataList;
	}

	public void combineArrayList(ArrayList<Data> csvDataList, ArrayList<Data> dataListFromTxt){


		for(Data d1 : csvDataList) {
			totalDataList.add(d1);
		}
		for(Data d2 : dataListFromTxt) {
			totalDataList.add(d2);
		}


	}

}

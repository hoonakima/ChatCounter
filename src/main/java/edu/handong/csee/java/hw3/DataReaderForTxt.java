package edu.handong.csee.java.hw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReaderForTxt implements DataReaderForFile {	

	public static ArrayList<Data> dataList = new ArrayList<Data>();

	public DataReaderForTxt() {

	}

	public ArrayList<Data> gettingMessageFromFiles(File file) {

		String line = null;
		String ymd = null;
		String hourMinute = null; 
		String name = null;
		String time = null;
		String message = null;

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));

			try {

				br.readLine();
				br.readLine();
				br.readLine();

				while((line = br.readLine())!= null) {

					String patternForYmd = "-+\\s([0-9]+).\\s([0-9]+).\\s([0-9]+).\\s...\\s-+";

					Pattern p1 = Pattern.compile(patternForYmd); //compile() returns Pattern
					Matcher m1 = p1.matcher(line);

					if(m1.find()) {
						ymd = m1.group(1)+ "-" + m1.group(2) + "-" + m1.group(3); 
						//for check						System.out.println(ymd);
						//ymd: 2018-4-27
					}

					String pattern = ".(.+).\\s.(..\\s[0-9]+.[0-9]+).\\s(.+)";
					Pattern p2 = Pattern.compile(pattern);
					Matcher m2 = p2.matcher(line);


					if(m2.find()) {
						Data data = new Data();

						name = m2.group(1);
						hourMinute = m2.group(2);
						message = m2.group(3);
						time = ymd + " " + hourMinute;

						DataReaderForTxt.dataScaling(data, ymd, hourMinute, name, message);

					}


				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}catch (UnsupportedEncodingException | FileNotFoundException e) {

			e.printStackTrace();
		}

		return dataList;

	}

	public static void dataScaling(Data data, String ymd, String hourMinute, String name, String message) {

		//I think I dont need to do this		String scaledName = "\"" + name + "\"";
		//										String scaledMessage = "\"" + message + "\"";
		String scaledYmd = ymd;
		String scaledHourMinute = hourMinute;

		if(hourMinute.contains("오전")) {
			scaledHourMinute = hourMinute.replace("오전 ", "");
			String[] devidingHourAndMinute = scaledHourMinute.split(":");

			int hour = Integer.parseInt(devidingHourAndMinute[0]);
			String minute = devidingHourAndMinute[1];

			if(1 <= hour && hour <= 9) {
				scaledHourMinute = "0" + hour + ":" + minute; 
			}
			else if(hour == 12) {
				scaledHourMinute = "00" + ":" + minute;
			}
			else{
				scaledHourMinute = hour + ":" + minute;
			}

		}

		if(hourMinute.contains("오후")) {

			scaledHourMinute = hourMinute.replace("오후 ", "");
			String[] devidingHourAndMinute = scaledHourMinute.split(":");

			int hour = Integer.parseInt(devidingHourAndMinute[0]);
			String minute = devidingHourAndMinute[1];
			if(hour == 12) {
				scaledHourMinute = hour + ":" + minute;
			}
			else {
				scaledHourMinute = hour + 12 + ":" + minute;
			}

		}try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ymd);
			scaledYmd = new SimpleDateFormat("yyyy-MM-dd").format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		data.setTime(scaledYmd + " " + scaledHourMinute);
		data.setName(name);
		data.setMessage(message);

		dataList.add(data);


	}

}


package edu.handong.csee.java.hw3;

import java.io.File;
import java.util.ArrayList;

public class DataReader {

	//directory path�� commend line����!

	public ArrayList<String> getData(String strDir){ //detail step�� private���� 

		//get directory
		File myDir = getDirectory(strDir);

		//get ListOfFilesFromDirectory(myDir)
		File[] files = getListOfFilesFromDirectory(myDir);

		ArrayList<String> messages = readFiles(files);

		return messages;

	}

	private File getDirectory(String strDir){

		File myDirectory = new File(strDir);
		return myDirectory;
	}

	private File[] getListOfFilesFromDirectory(File dataDir){

		return dataDir.listFiles(); //file object�� ���� method�ִ� for example, "list()" >return String array. But we want File array
	}								 //file.path

	private ArrayList<String> readFiles(File[] files){

		ArrayList<String> messages = new ArrayList<String>();

		return messages;
		//to read files we need main method
	}
}

package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ChatMessageCounter {

	public static void main(String[] args) {

		Path filePath = Paths.get(args[0]);
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(filePath);
		}
		catch(IOException e){
			System.out.println ("Error");
			System.exit (0);
		}
		while(inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			System.out.println(line);
		}
		inputStream.close();
		

	}
}

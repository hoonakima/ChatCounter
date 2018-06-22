//package edu.handong.csee.java.hw3;
//
//import org.apache.commons.cli.CommandLine;
//import org.apache.commons.cli.CommandLineParser;
//import org.apache.commons.cli.DefaultParser;
//import org.apache.commons.cli.HelpFormatter;
//import org.apache.commons.cli.Option;
//import org.apache.commons.cli.Options;
//import org.apache.commons.cli.ParseException;
//
//public class ChatMessageCounter {
//	
//	static String inputPath;
//	static String outputPath;
//	static boolean help;
//	static boolean verbose;
//	
//
//	public static void main(String[] args) {
//		
//		ChatMessageCounter counter = new ChatMessageCounter();
//		counter.operateCLI(args);
//		
//		DataReader reader = new DataReader();
//		reader.readFiles(inputPath);
//		
//		
//	
//	}
//	
//	public void operateCLI(String[] args) {
//		
//		Options options = createOptions();
//		
//		if(parseOptions(options, args)) {
//			if(help) {
//				printHelp(options);
//				return;
//			}
//			
//			System.out.println("You provided \"" + inputPath + "\" as the value of the option i");
//			System.out.println("You provided \"" + outputPath + "\" as the value of the option o");
//			
//			if(verbose) {
//				
//				System.out.println("Your program is terminated. (This message is shown because you turned on -v option!");
//				
//			}
//		}
//		
//		
//		
//		
//	}
//	// Parsing Stage
//	private boolean parseOptions(Options options, String[] args) {
//		CommandLineParser parser = new DefaultParser();
//		
//		try {
//			CommandLine cmd = parser.parse(options, args);
//			
//			inputPath = cmd.getOptionValue("i");
//			outputPath = cmd.getOptionValue("o");
//			help = cmd.hasOption("h");
//			verbose = cmd.hasOption("v");
//			
//		} catch (ParseException e) {
//			printHelp(options);
//			e.printStackTrace();
//			return false;
//		}
//		
//		return true;
//	}
//	
//	// Definition Stage
//	private Options createOptions() {
//		Options options = new Options();
//		
//		options.addOption(Option.builder("i").longOpt("inputPath")
//			   .desc("Set a input path of a directory or a file to display")
//			   .hasArg()
//			   .argName("Input path name to display")
//			   .required()
//			   .build());
//		
//		options.addOption(Option.builder("o").longOpt("outputPath")
//		   .desc("Set a output path of a directory or a file to display")
//		   .hasArg()
//		   .argName("Input path name to display")
//		   .required()
//		   .build());
//	
//		options.addOption(Option.builder("v").longOpt("verbose")
//		   .desc("Display detailed messages!")
//		   .argName("verbose option")
//		   .build());
//	
//		options.addOption(Option.builder("h").longOpt("help")
//		   .desc("Help")
//		   .build());
//		
//		return options;
//	
//		
//	}
//	
//	private void printHelp(Options options) {
//		HelpFormatter formatter = new HelpFormatter();
//		String header = "CLI test program";
//		String footer ="\nPlease report issues at https://github.com/lifove/CLIExample/issues";
//		formatter.printHelp("CLIExample", header, options, footer, true);
//	}
//	
//
//}

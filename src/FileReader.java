import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	
	/**
	 * 
	 * @param filename
	 * @return lyrics arraylist
	 */
	public static ArrayList<String> readCSV(String filename) {
		ArrayList<String> lyrics = new ArrayList<>();
		File lyricsFile = new File(filename);
		try {		
			Scanner fileReader = new Scanner(lyricsFile);
			fileReader.nextLine();
			while(fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String[] lineComponents = line.split(",");
				String lyricsWords = lineComponents[0];
				if(lyricsWords.contains("\"") ){
					lyricsWords = lyricsWords.replaceAll("\"", "");
					lyrics.add(lyricsWords.toLowerCase());
				}
				
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lyrics;
	}
	
	/**
	 * 
	 * @param filename
	 * @return name arraylist
	 */
	
	public static ArrayList<String> readTXT (String filename){
		ArrayList<String> names = new ArrayList<String>();
		File nameFile = new File(filename);
		try {
			Scanner fileReader = new Scanner(nameFile);
			while(fileReader.hasNextLine()) {
				String s = fileReader.nextLine();
				if(!s.isEmpty()) {
					names.add(s);
				}
				
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return names;	
	}
	
}

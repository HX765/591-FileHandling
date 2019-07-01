import java.util.ArrayList;
import java.util.Arrays;

public class main {

	public static void countWords(String filename, String words) {
		ArrayList<String> lyrics = new ArrayList<String>();
		lyrics = FileReader.readCSV(filename);

		double countWords = 0;
		double countAll = 0;

		for(int i = 0; i < lyrics.size(); i++) {
			for(int j = 0; j < lyrics.get(i).length(); j++) {
				countAll += lyrics.get(i).length();
				if(lyrics.get(i).contains(words)){
					countWords ++;
				}
			}

		}
		System.out.println("The number of " + words + " is "+ countWords);
		System.out.println("The number of total words is "+ countAll);
		System.out.println("The percentage of " + words + " is " + countWords / countAll);
		
	}
	
	

	public static void findAnagram(String filename) {
		ArrayList<String> names = new ArrayList<String>();
		names = FileReader.readTXT(filename);
		
		for(int i = 0; i < names.size(); i++) {
			for(int j = i+1; j < names.size(); j++) {
				if(isAnagram(names.get(i), names.get(j))){
					System.out.println(names.get(i) + " has an anagram " + names.get(j));
				}
			}
		}
		
	}
	
	public static boolean isAnagram(String str1, String str2) {  
		boolean status = true;  
		if (str1.length() != str2.length()) {  
			status = false;  
		} else {  
			char[] ArrayS1 = str1.toLowerCase().toCharArray();  
			char[] ArrayS2 = str2.toLowerCase().toCharArray();  
			Arrays.sort(ArrayS1);  
			Arrays.sort(ArrayS2);  
			status = Arrays.equals(ArrayS1, ArrayS2);  
		}  
		if (status) {  
			return true;
		} else {  
			return false;
		}  
	}   	
	

	public static void main(String[] args) {

		String filename = "Week-8-Recitation-beatles.csv";
		
		countWords(filename, "love");
		
		System.out.println();

		filename = "Week-8-Recitation-names.txt";
		
		findAnagram(filename);


	}

}

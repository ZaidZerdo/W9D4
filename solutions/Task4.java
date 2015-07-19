package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Task4 {

	public static void main(String[] args) {
		TreeMap<String, Integer> countWords = new TreeMap<>();
				
		Scanner input = null;
		
		try {
			input = new Scanner(new File("src/solutions/text.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file.");
			System.exit(1);
		}
		
		while (input.hasNext()) {
			String s = input.next();
			if (!countWords.containsKey(s)) {
				countWords.put(s, 0);
			}
			
			countWords.put(s, countWords.get(s) + 1);
		}
		
		input.close();
		
		// Output to file sorted by name
		PrintWriter writer = null;		
		try {
			writer = new PrintWriter(new File("src/output1.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		Iterator<String> it = countWords.keySet().iterator();
		while (it.hasNext()) {
			String s = it.next();
			
			writer.write(s + " -> " + countWords.get(s) + "\r\n");
		}		
		writer.close();
	}

}

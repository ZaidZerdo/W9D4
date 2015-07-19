package solutions;

import java.util.Scanner;
import java.util.TreeSet;

public class Task2 {

	public static void main(String[] args) {
		TreeSet<Character> allChars = new TreeSet<>();
		Scanner input = new Scanner(System.in);
		String s = null;		
		
		while (true) {
			s = input.next();
			
			if ("end".equals(s)) {
				break;
			}
			
			for (char c : s.toCharArray()) {
				allChars.add(c);
			}			
		}
		
		input.close();
	
		System.out.println(allChars);
	}

}

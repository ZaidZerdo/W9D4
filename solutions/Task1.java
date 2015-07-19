package solutions;

import java.util.ArrayList;
import java.util.ListIterator;

public class Task1 {

	public static void main(String[] args) {
		// Make the first list
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			list.add((int) (Math.random() * 51 + 50));
		}
		System.out.println(list);
		
		// Make the second list
		ArrayList<Integer> newList = new ArrayList<>();
		ListIterator<Integer> it = list.listIterator();
		while (it.hasNext()) {
			newList.add(it.next());
		}
		
		while (it.hasPrevious()) {
			newList.add(it.previous());
		}
		
		System.out.println(newList);		
	}

}

package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;

import solutions.Task3.Country.SortType;

public class Task3 {

	public static void main(String[] args) {
		ArrayList<Country> list = new ArrayList<>();
		list.add(new Country("C3", 50, 100));
		list.add(new Country("C2", 50, 120));
		list.add(new Country("C1", 100, 100));
		
		EnumSet<SortType> set = EnumSet.of(SortType.BY_NAME, SortType.BY_AREA);
		Country.sortBy(list, set);
		
		System.out.println(list);
	}
	
	public static class Country {
		public static enum SortType {
			BY_NAME, BY_POPULATION, BY_AREA
		}
		
		private String name;
		private Integer population;
		private Integer area;
		
		public Country(String name, Integer population, Integer area) {
			this.name = name;
			this.population = population;
			this.area = area;
		}

		public static void sortBy(ArrayList<Country> list, EnumSet<SortType> sortType) {
			if (sortType.contains(SortType.BY_NAME)) {
				Collections.sort(list, new Comparator<Country>() {

					@Override
					public int compare(Country a1, Country a2) {
						return a1.name.compareTo(a2.name);
					}
					
				});
			}
			
			if (sortType.contains(SortType.BY_POPULATION)) {
				Collections.sort(list, new Comparator<Country>() {

					@Override
					public int compare(Country a1, Country a2) {
						return a1.population - a2.population;
					}
					
				});
			}
			
			if (sortType.contains(SortType.BY_AREA)) {
				Collections.sort(list, new Comparator<Country>() {

					@Override
					public int compare(Country a1, Country a2) {
						return a1.area - a2.area;
					}
					
				});
			}
	
		}
		
		public String toString() {
			return name + "(" + population + ", " + area + ")";
		}
	
	}

}

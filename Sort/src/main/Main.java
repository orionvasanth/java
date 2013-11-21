package main;
import logic.*;
import java.util.*;

public class Main extends ReadWrite{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<SortingInterface> sorts = new ArrayList<SortingInterface>();
		sorts.add(new Insertion());
		sorts.add(new Selection());
		sorts.add(new Merge());
		sorts.add(new Quick());
		sorts.add(new Heap());
		
		Integer[] input = readArray();
				
		for(SortingInterface sort : sorts) {
			Integer[] x = input.clone();
			sort.sort(x);
		}
		
		//print(input);
	}

}

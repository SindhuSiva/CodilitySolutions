package com.codility.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermMissingElem {

	public static void main(String[] args) {
		final int[] n = { 1, 2, 3, 4, 6, 7 , 5, 8, 10};
		int num = 0;
		num = mySol2(n);
		System.out.println("num: " + num);
	}

	// Works for most
	private static int mySol1(int[] n) {
		Set<Integer> set1 = new HashSet<Integer>();
		List<Integer> index = new ArrayList<Integer>();
		for (int i = 0; i < n.length; i++) {
			set1.add(n[i]);
			index.add(i + 1);
		}
		index.removeAll(set1);
		return index.get(0);
	}
	
	// Detected time complexity: O(N) or O(N * log(N))
	private static int mySol2(int[] n) {
		Set<Integer> set1 = new HashSet<Integer>();
		for (int i = 0; i < n.length; i++) {
			set1.add(n[i]);
		}
		for (int i = 1; i <= Integer.MAX_VALUE; i++) {
			if(!set1.contains(i))
				return i;
		}
		return 1;
	}

}

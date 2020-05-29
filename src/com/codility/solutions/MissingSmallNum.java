package com.codility.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingSmallNum {

	public static void main(String[] args) {
		System.out.println(mySol1( new int[] { -1, -8, 0, 1, 9 }));
		System.out.println(mySol2( new int[] { -1, -8, 0, 1, 9 }));
    System.out.println(mySol3( new int[] { -1, -8, 0, 1, 9 }));
	}

	// Had performance issues
	private static int mySol1(int[] in) {
		Arrays.sort(in);
		List<Integer> list = IntStream.of(in).boxed().collect(Collectors.toList());
		System.out.println("arr: " + list);
		List<Integer> result = (List<Integer>) list.stream().filter(num -> (num > 0)).collect(Collectors.toList());
		System.out.println("arr: " + result);
		int small = 1, big = 1, lowest = 1;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i) > 0) {
				if (result.get(i) - 1 == small) {
					small = result.get(i);
				}
				if (result.get(i) >= big) {
					big = result.get(i);
				}
			}
			System.out.println("small " + small + ", big " + big);
		}
		if (!result.isEmpty()) {
			if (small < result.get(0)) {
				lowest = small;
			} else if (small >= 1) {
				lowest = small + 1;
			}
		}
		System.out.println("low " + lowest);
		return lowest;
	}

//	 100% correctness
	private static int mySol2(int[] in) {
		Set<Integer> testedSet = new TreeSet<Integer>();
		Set<Integer> perfectSet = new TreeSet<Integer>();

		for (int i = 0; i < in.length; i++) {
			testedSet.add(in[i]); // convert array to set to get rid of duplicates, order int's
			perfectSet.add(i + 1); // create perfect set so can find missing int
		}
		System.out.println("testedSet " + testedSet);
		System.out.println("perfectSet " + perfectSet);
		for (Object current : perfectSet) {
			if (!testedSet.contains(current)) {
				return (Integer) current;
			}
		}

		if (perfectSet.size() == testedSet.size()) {
			return perfectSet.size() + 1; // e.g. {1, 2, 3} should return 4
		}

		return 1; // default - e.g. if A array has negative values or just a single positive value
					// like 10
	}

	// Detected time complexity: O(N) or O(N * log(N)) 100% correctness
	private static int mySol3(int[] A) {
		// write your code in Java SE 8
		Set<Integer> positiveNum = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				positiveNum.add(A[i]);
			}
		}
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!positiveNum.contains(i)) {
				return i;
			}
		}
		return 1;
	}

}

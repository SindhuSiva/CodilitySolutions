package com.codility.solutions;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 2, 4, 3 }));
	}

	// Detected time complexity: O(N) or O(N * log(N)) - 100/100
	private static int solution(int[] A) {
		int missing = 1;
		Set<Integer> num = new HashSet<Integer>();
		for (Integer n : A) {
			if (n > 0) {
				num.add(n);
			}
		}
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!num.contains(i)) {
				return i;
			}
		}

		return missing;
	}

}

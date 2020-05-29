package com.codility.solutions;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 4 }));
		System.out.println(solution(new int[] { 3, 1, 4, 2 }));
		System.out.println(solution(new int[] { 3, 1, 4 }));
		System.out.println(solution(new int[] { 3, 1, 4, 2, 6 }));
	}

	// Detected time complexity: O(N) or O(N * log(N))
	private static int solution(int[] A) {
		Set<Integer> num = new HashSet<Integer>();
		for (Integer integer : A) {
			num.add(integer);
		}
		for (int i = 1; i <= A.length; i++) {
			if (!num.contains(i)) {
				return 0;
			}
		}
		return 1;
	}

}

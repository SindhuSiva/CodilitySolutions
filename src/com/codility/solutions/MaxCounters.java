package com.codility.solutions;

import java.util.Arrays;

public class MaxCounters {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 })));
		System.out.println(Arrays.toString(solution(5, new int[] { 3, 4, 4, 6, 6, 4, 4 })));
		System.out.println(Arrays.toString(solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4, 6 })));
		System.out.println(Arrays.toString(solution(1, new int[] { 2, 1, 1, 2, 1 })));
		System.out.println(Arrays.toString(solution(2, new int[] { 2, 1, 1, 2, 1 })));
	}

	//Detected time complexity: O(N + M) 100/100
	private static int[] solution(int N, int[] A) {
		int[] counter = new int[N];
		int max = 0, prevMax = 0;
		for (int k = 0; k < A.length; k++) {
			if (A[k] == N + 1) {
				prevMax = max;
			} else {
				counter[A[k] - 1] = Math.max(counter[A[k] - 1], prevMax);
				counter[A[k] - 1] += 1;
				max = Math.max(max, counter[A[k] - 1]);
			}
		}
		for(int i = 0 ; i < counter.length; i++) {
			counter[i] = Math.max(counter[i], prevMax);
		}
		return counter;
	}

	// Detected time complexity: O(N*M) 100% correctness but perfomance issues.
	private static int[] solution1(int N, int[] A) {
		int[] counter = new int[N];
		int max = 0;
		for (int X : A) {
			if (X == N + 1) {
				Arrays.sort(counter);
				max = counter[N - 1];
				maxCounter(counter, max);
			} else {
				counter[X - 1] += 1;
				max = Math.max(max, X - 1);
			}
			// System.out.println(Arrays.toString(counter));
		}
		return counter;
	}

	private static void maxCounter(int[] counter, int max) {
		for (int i = 0; i < counter.length; i++) {
			counter[i] = max;
		}
	}

}

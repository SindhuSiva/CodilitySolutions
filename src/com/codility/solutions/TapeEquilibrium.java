package com.codility.solutions;

public class TapeEquilibrium {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 2, 4, 3 }));
		System.out.println(solution(new int[] { 30, 11, 23, 41, 3 }));
		System.out.println(solution(new int[] { 3, 1 }));
		System.out.println(solution(new int[] { -3, -1, -2, -4, -3 }));
	}

	// Detected time complexity: O(N)
	private static int solution(int[] A) {
		int sumA = 0, sumP = 0, diff = Integer.MAX_VALUE, nextDiff = 0;
		for (int n = 0; n < A.length; n++) {
			sumA += A[n];
		}

		for (int p = 1; p < A.length; p++) {
			sumP += A[p - 1];
			nextDiff = sumA - sumP;
			diff = Math.min(diff, Math.abs(sumP - nextDiff));
		}
		return diff;
	}

}

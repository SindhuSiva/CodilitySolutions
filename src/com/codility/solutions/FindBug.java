package com.codility.solutions;

public class FindBug {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {-1,1,0,-4}));
	}

	static int solution(int[] A) {
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			if (ans > A[i]) {
				ans = A[i];
			}
		}
		return ans;
	}
}

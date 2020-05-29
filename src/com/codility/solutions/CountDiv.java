package com.codility.solutions;

import java.util.ArrayList;
import java.util.List;

public class CountDiv {

	public static void main(String[] args) {
		System.out.println(solution(6, 11, 2));
		System.out.println(solution(3, 10, 2));
		System.out.println(solution(13, 50, 5));
		System.out.println(solution(4, 100, 20));
		System.out.println(solution(0, 0, 11));
	}

	// Detected time complexity: O(1)
	private static int solution(int i, int j, int k) {
		return (j / k) - (i / k) + ((i % k) == 0 ? 1 : 0);
	}

	// 100% correct but has performance issues. Detected time complexity: O((B-A)/K)
	private static int solution1(int i, int j, int k) {
		List<Integer> num = new ArrayList<Integer>();
		int div = 0;
		for (int l = i; l <= j; l++) {
			div = l % k;
			if (div == 0) {
				num.add(l);
				l += (k - 1);
			}
		}
		System.out.println(num);
		return num.size();
	}

}

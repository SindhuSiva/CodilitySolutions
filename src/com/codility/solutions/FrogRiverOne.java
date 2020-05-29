package com.codility.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class FrogRiverOne {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		System.out.println(solution(5, new int[] { 1, 3, 1, 4, 5, 3, 2, 5 }));
		System.out.println(solution(5, new int[] { 1, 3, 1, 4, 5, 3, 5, 2 }));
		System.out.println(solution(2, new int[] { 1, 1, 1, 2 }));
		System.out.println(solution(10, new int[] { 10, 2, 5, 6, 7, 1, 3, 4, 7, 9, 8, 10, 9, 10, 10 }));
		System.out.println(solution(10, randomFill(100, 10)));
		System.out.println(solution(2, new int[] { 1, 1, 1, 1 }));

	}

	// Detected time complexity: O(N) 100% correctness
	private static int solution(int x, int[] a) {

		int seconds = -1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (!map.containsKey(a[i]) || !map.containsKey(x))
				map.put(a[i], i);
		}
		Set<Integer> keys = map.keySet();
		for (int i = 1; i <= x; i++) {
			if (!keys.contains(i)) {
				return seconds;
			}
		}
		for (int i = 1; i <= x; i++) {
			seconds = Math.max(seconds, map.get(i));
		}
		return seconds;
	}

	// Detected time complexity: O(N) 100% correctness
	private static int solution1(int x, int[] a) {
		int seconds = -1;
		Set<Integer> value = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= x) {
				value.add(a[i]);
			}

			if (value.size() == x) {
				return i;
			}
		}
		return seconds;
	}

	private static int[] randomFill(int n, int X) {
		int[] arr = new int[n];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(X) + 1;
		}

		return arr;
	}

}

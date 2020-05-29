package com.codility.solutions;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CyclicRotation {

	public static void main(String[] args) {
		final int[] A = { 3, 8, 9, 7, 6 };
		final int[] B = { 3, 8, 9, 7, 6 };
		int[] shifted = null;
		shifted = mySol(A, 1);
		System.out.println(IntStream.of(shifted).boxed().collect(Collectors.toList()));
		System.out.println("=====");
		shifted = mySol(B, 2);
		System.out.println(IntStream.of(shifted).boxed().collect(Collectors.toList()));
	}

	private static int[] mySol1(int[] a, int k) {
		List<Integer> list = IntStream.of(a).boxed().collect(Collectors.toList());
		System.out.println("original: " + list);
		Collections.rotate(list, k);
		System.out.println("shidt: " + list);
		// Integer[] shifted = list.toArray(new Integer[list.size()]);
		int[] shifted = list.stream().mapToInt(i -> i).toArray();
		return shifted;
	}

	private static int[] mySol(int[] a, int k) {
		final List<Integer> list = IntStream.of(a).boxed().collect(Collectors.toList());
		System.out.println("original: " + list);
		for (int i = 0; i < k; i++) {
			int j, last;
			// Stores the last element of array
			last = a[a.length - 1];

			for (j = a.length - 1; j > 0; j--) {
				// Shift element of array by one
				a[j] = a[j - 1];
			}
			// Last element of array will be added to the start of array.
			a[0] = last;
		}
		return a;
	}

}

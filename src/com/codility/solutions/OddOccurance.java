package com.codility.solutions;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddOccurance {

	public static void main(String[] args) {
		int odd = 0;
		int a[] = { 9, 1, 9, 1, 5, 3, 2, 3, 2 };
		odd = mySol1(a);
		System.out.println("odd " + odd);
		odd = mySol2(a);
		System.out.println("odd " + odd);
	}

	// Detected time complexity: O(N**2) --> Higher time
	private static int mySol1(int[] a) {
		List<Integer> original = IntStream.of(a).boxed().collect(Collectors.toList());
		List<Integer> odd = original.stream().filter(e -> (Collections.frequency(original, e) % 2) == 1)
				.collect(Collectors.toList());
		return odd.get(0);
	}

	// Detected time complexity: O(N) or O(N*log(N))
	private static int mySol2(int[] a) {
		int odd = 0;
		for (int i = 0; i < a.length; i++) {
			odd ^= a[i];
		}
		return odd;
	}

}

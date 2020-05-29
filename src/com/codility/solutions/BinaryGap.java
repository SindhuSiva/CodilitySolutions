package com.codility.solutions;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryGap {

	public static void main(String[] args) {
		// final Scanner scan = new Scanner(System.in);
		// final int num = scan.nextInt();
		int num = 1610612737;
		num = 2147483647;
		final int gaps = mySol(num);
		System.out.println("gaps: " + gaps);
		num = 2147483647;
		System.out.println("gaps: " + mySol(num));
	}

	private static int mySol(int num) {
		final String binary = Integer.toBinaryString(num);
		System.out.println("binary : " + binary);
		char[] cArr = binary.toCharArray();
		System.out.println("arr: " + Arrays.toString(cArr));
		int length = cArr.length, i = 1;
		int arr[] = new int[length];
		int index = binary.indexOf("1");
		arr[0] = index;
		while (index >= 0 && (index + 1) < length) {
			index = binary.indexOf("1", index + 1);
			// arr[i++] = (index == -1 ? 0 : index);
			arr[i++] = index;
		}
		System.out.println("arr: " + Arrays.toString(arr));
		int ans = 0;
		for (int j = 0; j < length - 1; ++j)
			ans = Math.max(ans, arr[j + 1] - arr[j]);

		if (ans > 0)
			ans -= 1;
		return ans;
	}

}

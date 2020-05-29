package com.codility.solutions;

public class FrogJump {

	public static void main(String[] args) {
		// final int x = 10, y = 85, d = 30;
		final int x = 1, y = 85, d = 10;
		int jumps = 0;
		jumps = mySol2(x, y, d);
		System.out.println("jumps: " + jumps);
	}

	// Works only partially
	private static int mySol1(int x, int y, int d) {
		int jumps = (int) Math.round((double) y / d);
		return jumps;
	}

	// Working. Detected time complexity: O(1)
	private static int mySol2(int x, int y, int d) {
		int step = (y - x) / d;
		int missing = (y - x) % d > 0 ? 1 : 0;
		int jumps = step + missing;
		return jumps;
	}

}

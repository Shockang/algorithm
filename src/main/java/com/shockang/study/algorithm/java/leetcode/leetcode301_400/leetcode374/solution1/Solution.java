package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode374.solution1;

/**
 * @author Shockang
 */
public class Solution extends GuessGame {
	private int i;

	public int guessNumber(int n) {
		i = n;
		int l = 1, r = n;
		while (l <= r) {
			int m = l + ((r - l) >> 1);
			switch (guess(m)) {
				case 0:
					return m;
				case 1:
					l = m + 1;
					break;
				default:
					r = m - 1;
			}
		}
		return l;
	}

	int guess(int pick) {
		return Integer.compare(i, pick);
	}
}

abstract class GuessGame {
	abstract int guess(int pick);
}
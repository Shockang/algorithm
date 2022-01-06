package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode344.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public void reverseString(char[] s) {
		if (s == null || s.length == 0) {
			return;
		}
		int n = s.length;
		for (int i = 0; i < n / 2; i++) {
			swap(s, i, n - i - 1);
		}
	}

	private void swap(char[] s, int x, int y) {
		s[x] ^= s[y];
		s[y] ^= s[x];
		s[x] ^= s[y];
	}
}
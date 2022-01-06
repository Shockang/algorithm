package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode338.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int[] countBits(int n) {
		int[] bits = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			bits[i] = bits[i & (i - 1)] + 1;
		}
		return bits;
	}
}
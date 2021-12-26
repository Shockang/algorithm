package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode279.solution1;

/**
 * 动态规划，i <= n, j*j <= i
 *
 * @author Shockang
 */
public class Solution {
	public int numSquares(int n) {
		// f 表示下标为 i 组成和的完全平方数的个数最少
		int[] f = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, f[i - j * j]);
			}
			f[i] = min + 1;
		}
		return f[n];
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode410.solution1;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int splitArray(int[] nums, int m) {
		int n = nums.length;
		int[][] f = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(f[i], Integer.MAX_VALUE);
		}
		int[] sub = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sub[i + 1] = sub[i] + nums[i];
		}
		f[0][0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= Math.min(i, m); j++) {
				for (int k = 0; k < i; k++) {
					f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
				}
			}
		}
		return f[n][m];
	}
}

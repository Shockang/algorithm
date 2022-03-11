package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode375.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n + 2][n + 2];
		for (int i = n; i > 0; i--) {
			for (int j = i; j <= n; j++) {
				if (i == j) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Integer.MAX_VALUE;
					for (int k = i; k <= j; k++) {
						dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
					}
				}
			}
		}
		return dp[1][n];
	}
}

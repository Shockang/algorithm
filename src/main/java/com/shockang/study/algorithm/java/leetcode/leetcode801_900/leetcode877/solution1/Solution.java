package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode877.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public boolean stoneGame(int[] piles) {
		int n = piles.length;
		// Alice 和 Bob 的石子数量之差
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = piles[i];
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
			}
		}
		return dp[0][n - 1] > 0;
	}
}
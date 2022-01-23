package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode123.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n][2][3];
		dp[0][1][2] = dp[0][1][1] = dp[0][1][0] = -prices[0];
		for (int i = 1; i < n; i++) {
			dp[i][0][2] = dp[i - 1][0][2];
			dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][2] + prices[i]);
			dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][1] + prices[i]);
			dp[i][1][2] = Math.max(dp[i - 1][0][2] - prices[i], dp[i - 1][1][2]);
			dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
			dp[i][1][0] = -1;
		}
		return Math.max(Math.max(dp[n - 1][0][0], dp[n - 1][0][1]), dp[n - 1][0][2]);
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode122.solution1;

/**
 * 动态规划
 *
 * @author Shockang
 */
public class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		dp[0][1] = -prices[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
		}
		return dp[n - 1][0];
	}
}
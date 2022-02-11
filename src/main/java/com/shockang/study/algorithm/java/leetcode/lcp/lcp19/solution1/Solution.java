package com.shockang.study.algorithm.java.leetcode.lcp.lcp19.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int minimumOperations(String leaves) {
		int n = leaves.length();
		int[][] dp = new int[n + 1][3];
		dp[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
		dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
		int isYellow, isRed;
		for (int i = 1; i < n; i++) {
			isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
			isRed = leaves.charAt(i) == 'r' ? 1 : 0;
			dp[i][0] = dp[i - 1][0] + isYellow;
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + isRed;
			if (i >= 2) {
				dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isYellow;
			}
		}
		return dp[n - 1][2];
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode664.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int strangePrinter(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j < n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i][j - 1];
				} else {
					for (int k = i; k < j; k++) {
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
					}
				}
			}
		}
		return dp[0][n - 1];
	}
}

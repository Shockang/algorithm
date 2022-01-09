package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode72.solution1;

/**
 * 动态规划
 *
 * @author Shockang
 */
public class Solution {
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		if (m + n == 0) return 0;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= n; j++) {
			dp[0][j] = j;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int insert = dp[i + 1][j];
					int delete = dp[i][j + 1];
					int replace = dp[i][j];
					dp[i + 1][j + 1] = Math.min(Math.min(insert, delete), replace) + 1;
				}
			}
		}
		return dp[m][n];
	}
}
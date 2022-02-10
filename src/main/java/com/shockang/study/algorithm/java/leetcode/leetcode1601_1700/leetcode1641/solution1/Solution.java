package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1641.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int countVowelStrings(int n) {
		int[][] dp = new int[n][5];
		dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					int k = j, count = 0;
					while (k >= 0) count += dp[i - 1][k--];
					dp[i][j] = count;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < 5; i++) {
			res += dp[n - 1][i];
		}
		return res;
	}
}

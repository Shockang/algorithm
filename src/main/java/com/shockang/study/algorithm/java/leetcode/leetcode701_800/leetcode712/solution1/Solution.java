package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode712.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int minimumDeleteSum(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];

		for (int i = n1 - 1; i >= 0; i--) {
			dp[i][n2] = dp[i + 1][n2] + s1.codePointAt(i);
		}
		for (int j = n2 - 1; j >= 0; j--) {
			dp[n1][j] = dp[n1][j + 1] + s2.codePointAt(j);
		}
		for (int i = n1 - 1; i >= 0; i--) {
			for (int j = n2 - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j] + s1.codePointAt(i),
							dp[i][j + 1] + s2.codePointAt(j));
				}
			}
		}
		return dp[0][0];
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode10.solution2;

/**
 * 10. 正则表达式匹配
 * <p>
 * 动态规划，有星无星，去两头还是去一头
 *
 * @author Shockang
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) return s.isEmpty();
		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 2; i <= n; i++) {
			dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (p.charAt(j) == '*') {
					dp[i + 1][j + 1] = dp[i + 1][j - 1] || (firstMatch(s, p, i, j - 1) && dp[i][j + 1]);
				} else {
					dp[i + 1][j + 1] = firstMatch(s, p, i, j) && dp[i][j];
				}
			}
		}
		return dp[m][n];
	}

	private boolean firstMatch(String s, String p, int i, int j) {
		return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
	}
}
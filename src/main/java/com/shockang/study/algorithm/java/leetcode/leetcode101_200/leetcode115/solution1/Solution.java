package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode115.solution1;

/**
 * 动态规划
 *
 * @author Shockang
 */
public class Solution {
	public int numDistinct(String s, String t) {
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
		for (int i = 1; i < t.length() + 1; i++) {
			for (int j = 1; j < s.length() + 1; j++) {
				if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				else dp[i][j] = dp[i][j - 1];
			}
		}
		return dp[t.length()][s.length()];
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode97.solution1;

/**
 * 路径问题，动态规划
 *
 * @author Shockang
 */
public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length(), n = s2.length();
		if (s3.length() != m + n) return false;
		// 动态规划，dp[i,j]表示s1前i字符能与s2前j字符组成s3前i+j个字符；
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= m && s1.charAt(i - 1) == s3.charAt(i - 1); i++) dp[i][0] = true; // 不相符直接终止
		for (int j = 1; j <= n && s2.charAt(j - 1) == s3.charAt(j - 1); j++) dp[0][j] = true; // 不相符直接终止
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
						|| (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
			}
		}
		return dp[m][n];
	}
}

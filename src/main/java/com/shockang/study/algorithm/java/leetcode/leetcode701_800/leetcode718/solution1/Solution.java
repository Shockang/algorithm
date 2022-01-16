package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode718.solution1;

/**
 * 动态规划
 *
 * @author Shockang
 */
public class Solution {
	public int findLength(int[] A, int[] B) {
		int n = A.length, m = B.length;
		int[][] dp = new int[n + 1][m + 1];
		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
				ans = Math.max(ans, dp[i][j]);
			}
		}
		return ans;
	}
}
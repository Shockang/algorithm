package com.shockang.study.algorithm.java.leetcode.leetcode1001_1100.leetcode1043.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int maxSumAfterPartitioning(int[] A, int K) {
		int n = A.length;
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			int j = i - 1;
			int max = dp[i];
			while ((i - j) <= K && j >= 0) {
				max = Math.max(max, A[j]);
				dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
				j--;
			}
		}
		return dp[n];
	}
}
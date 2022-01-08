package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode486.solution1;

/**
 * 动态规划
 *
 * @author Shockang
 */
public class Solution {
	public boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = nums[i];
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
			}
		}
		return dp[n - 1] >= 0;
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode198.solution2;

/**
 * @author Shockang
 */
public class Solution {
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		return dp[n - 1];
	}
}
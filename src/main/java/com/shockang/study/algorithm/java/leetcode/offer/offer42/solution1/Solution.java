package com.shockang.study.algorithm.java.leetcode.offer.offer42.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int maxSubArray(int[] nums) {
		if (nums.length == 1) return nums[0];
		int n = nums.length, cur = nums[0], max = nums[0];
		for (int i = 1; i < n; i++) {
			cur = Math.max(nums[i], nums[i] + cur);
			max = Math.max(max, cur);
		}
		return max;
	}
}
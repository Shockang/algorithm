package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode53.solution1;

/**
 * cur,max
 *
 * @author Shockang
 */
public class Solution {
	public int maxSubArray(int[] nums) {
		if (nums.length == 1) return nums[0];
		int n = nums.length, cur = nums[0], max = nums[0];
		for (int i = 1; i < n; i++) {
			cur = Math.max(nums[i], cur + nums[i]);
			max = Math.max(max, cur);
		}
		return max;
	}
}

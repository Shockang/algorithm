package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode34.solution1;

/**
 * 第一个等于值，helper(nums, target + 1) - 1
 *
 * @author Shockang
 */
public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int first = helper(nums, target);
		if (first == nums.length || nums[first] != target) return new int[]{-1, -1};
		return new int[]{first, helper(nums, target + 1) - 1};
	}

	private int helper(int[] nums, int target) {
		int low = 0, high = nums.length;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			if (nums[mid] < target) low = mid + 1;
			else high = mid;
		}
		return high;
	}
}
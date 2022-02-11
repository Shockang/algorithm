package com.shockang.study.algorithm.java.leetcode.offer.offer03.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int findRepeatNumber(int[] nums) {
		int n = nums.length;
		int[] counts = new int[n];
		for (int i = 0; i < n; i++) {
			int cur = counts[nums[i]] + 1;
			if (cur > 1) {
				return nums[i];
			}
			counts[nums[i]] = cur;
		}
		return 0;
	}
}
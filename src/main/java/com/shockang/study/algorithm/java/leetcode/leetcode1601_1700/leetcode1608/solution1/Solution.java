package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1608.solution1;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int specialArray(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length, x = 1;
		if (nums[0] >= n) {
			return n;
		}
		for (int i = n - 1; i >= 1; i--) {
			if (nums[i] >= x && nums[i - 1] < x) {
				return x;
			}
			x++;
		}
		return -1;
	}
}

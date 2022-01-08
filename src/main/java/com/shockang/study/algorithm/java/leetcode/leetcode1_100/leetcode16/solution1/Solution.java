package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode16.solution1;

import java.util.Arrays;

/**
 * sort+双指针+abs
 *
 * @author Shockang
 */
public class Solution {

	public int threeSumClosest(int[] nums, int target) {
		int len = nums.length, result = nums[0] + nums[1] + nums[len - 1];
		Arrays.sort(nums);
		for (int i = 0; i < len - 2; i++) {
			int start = i + 1, end = len - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode1901_2000.leetcode1984.solution1;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int minimumDifference(int[] nums, int k) {
		int n = nums.length;
		Arrays.sort(nums);
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i + k - 1 < n; ++i) {
			ans = Math.min(ans, nums[i + k - 1] - nums[i]);
		}
		return ans;
	}
}

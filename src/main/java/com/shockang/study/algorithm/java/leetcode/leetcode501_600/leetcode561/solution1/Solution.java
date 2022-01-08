package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode561.solution1;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int ans = 0;
		for (int i = 0; i < nums.length; i += 2) {
			ans += nums[i];
		}
		return ans;
	}
}
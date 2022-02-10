package com.shockang.study.algorithm.java.leetcode.leetcode1401_1500.leetcode1403.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<Integer> minSubsequence(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		sum = sum / 2;
		int count = 0;
		List<Integer> res = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; --i) {
			count += nums[i];
			res.add(nums[i]);
			if (count > sum) {
				return res;
			}
		}
		return res;
	}
}
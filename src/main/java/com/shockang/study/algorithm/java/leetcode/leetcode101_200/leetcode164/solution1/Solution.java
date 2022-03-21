package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode164.solution1;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;

		int min = nums[0];
		int max = nums[0];
		for (int n : nums) {
			min = Math.min(min, n);
			max = Math.max(max, n);
		}
		if (min == max)
			return 0;

		int n = nums.length;

		int gap = (int) Math.ceil((double) (max - min) / (n - 1));
		int bucketMin[] = new int[n];
		int bucketMax[] = new int[n];
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);

		for (int num : nums) {
			int i = (num - min) / gap;
			bucketMin[i] = Math.min(bucketMin[i], num);
			bucketMax[i] = Math.max(bucketMax[i], num);
		}


		for (int i = 0; i < bucketMin.length; ++i) {
			if (bucketMin[i] != Integer.MAX_VALUE) {
				gap = Math.max(gap, bucketMin[i] - min);
				min = bucketMax[i];
			}
		}

		return gap;
	}
}
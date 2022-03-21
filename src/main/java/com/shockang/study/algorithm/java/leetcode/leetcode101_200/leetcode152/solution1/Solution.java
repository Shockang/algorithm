package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode152.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int maxProduct(int[] nums) {
		int r = nums[0];
		for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tmp = imin;
				imin = imax;
				imax = tmp;
			}
			imax = Math.max(nums[i], imax * nums[i]);
			imin = Math.min(nums[i], imin * nums[i]);
			r = Math.max(r, imax);
		}
		return r;
	}
}
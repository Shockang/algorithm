package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode303.solution1;

/**
 * 数组存储前 N 项和
 *
 * @author Shockang
 */
public class NumArray {

	private int[] nums;

	public NumArray(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		if (i == 0) {
			return nums[j];
		}
		return nums[j] - nums[i - 1];
	}
}
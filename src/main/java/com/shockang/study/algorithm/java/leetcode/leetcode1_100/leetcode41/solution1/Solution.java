package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode41.solution1;

/**
 * 3 次遍历，小于0都取大，所有取绝对值，小值取反，返回第一个大于0
 *
 * @author Shockang
 */
public class Solution {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			if (nums[i] <= 0) {
				nums[i] = n + 1;
			}
		}
		for (int i = 0; i < n; ++i) {
			int num = Math.abs(nums[i]);
			if (num <= n) {
				nums[num - 1] = -Math.abs(nums[num - 1]);
			}
		}
		for (int i = 0; i < n; ++i) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		return n + 1;
	}
}
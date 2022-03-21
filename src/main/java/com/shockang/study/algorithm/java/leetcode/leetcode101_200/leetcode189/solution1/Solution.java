package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode189.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		int len2 = len - k % len;
		rotate(nums, 0, len2 - 1);
		rotate(nums, len2, len - 1);
		rotate(nums, 0, len - 1);
	}

	private void rotate(int[] nums, int start, int end) {
		while (start < end) {
			exchange(nums, start++, end--);
		}
	}

	private void exchange(int[] nums, int x, int y) {
		nums[x] = nums[x] ^ nums[y];
		nums[y] = nums[x] ^ nums[y];
		nums[x] = nums[x] ^ nums[y];
	}
}
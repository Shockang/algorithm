package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode905.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int[] sortArrayByParity(int[] nums) {
		int n = nums.length, i = 0, j = n - 1;
		while (i < j) {
			while (i < n && nums[i] % 2 == 0) {
				i++;
			}
			while (j >= 0 && nums[j] % 2 == 1) {
				j--;
			}
			if (i < j) {
				swap(nums, i, j);
				i++;
				j--;
			}
		}
		return nums;
	}

	private void swap(int[] nums, int x, int y) {
		int tmp = nums[x];
		nums[x] = nums[y];
		nums[y] = tmp;
	}
}
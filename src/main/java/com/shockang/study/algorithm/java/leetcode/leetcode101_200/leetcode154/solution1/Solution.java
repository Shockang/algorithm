package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode154.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int pivot = low + (high - low) / 2;
			if (nums[pivot] < nums[high]) {
				high = pivot;
			} else if (nums[pivot] > nums[high]) {
				low = pivot + 1;
			} else {
				high -= 1;
			}
		}
		return nums[low];
	}
}
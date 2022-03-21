package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode153.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int middle = (left + right) / 2;
			if (nums[middle] < nums[right]) {
				// middle可能是最小值
				right = middle;
			} else {
				// middle肯定不是最小值
				left = middle + 1;
			}
		}
		return nums[left];
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode162.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int findPeakElement(int[] nums) {
		int N = nums.length;
		if (N == 1) {
			return 0;
		}

		int left = 0, right = N - 1;
		while (right - left > 1) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
	}
}

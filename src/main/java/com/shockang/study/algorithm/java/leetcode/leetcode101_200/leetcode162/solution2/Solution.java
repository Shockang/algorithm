package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode162.solution2;

/**
 * @author Shockang
 */
public class Solution {
	public int findPeakElement(int[] nums) {
		int l = 0, n = nums.length, r = n - 1;
		while (l <= r) {
			int mid = l + ((r - l) >> 1);
			if (mid + 1 < n && nums[mid] < nums[mid + 1]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}
}
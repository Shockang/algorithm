package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode162.solution3;

/**
 * @author Shockang
 */
public class Solution {
	public int findPeakElement(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = l + ((r - l) >> 1);
			if (nums[mid] < nums[mid+1]) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return l;
	}
}
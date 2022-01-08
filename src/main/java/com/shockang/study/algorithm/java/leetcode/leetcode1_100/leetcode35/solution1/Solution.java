package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode35.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int searchInsert(int[] nums, int target) {
		int n = nums.length, left = 0, right = n - 1, ans = n;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (target <= nums[mid]) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}
}
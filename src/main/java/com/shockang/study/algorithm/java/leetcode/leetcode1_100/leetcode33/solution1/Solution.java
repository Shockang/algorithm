package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode33.solution1;

/**
 * 二分查找，先判断在中间
 *
 * @author Shockang
 */
public class Solution {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0, end = nums.length - 1, mid;
		while (start < end) {
			mid = start + ((end - start) >> 1);
			if (target == nums[mid]) {
				return mid;
			}
			if (nums[start] <= nums[mid]) {
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return nums[start] == target ? start : -1;
	}
}
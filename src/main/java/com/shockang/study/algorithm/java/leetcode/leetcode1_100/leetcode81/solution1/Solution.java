package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode81.solution1;

/**
 * 先判断 target 位于中间的，left <= target < mid，mid < target <= right
 *
 * @author Shockang
 */
public class Solution {
	public boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid]) {
				return true;
			}
			if (nums[left] < nums[mid]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[left] == nums[mid]) {
				left++;
			} else {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return false;
	}
}
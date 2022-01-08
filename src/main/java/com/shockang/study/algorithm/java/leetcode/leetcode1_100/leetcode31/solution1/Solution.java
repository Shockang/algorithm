package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode31.solution1;

/**
 * 后->前，找第一个连续降序前一个数字，然后二分查找刚好比它大的，交换，降序改升序
 *
 * @author Shockang
 */
public class Solution {
	public void nextPermutation(int[] nums) {
		int n = 0;
		if (nums == null || (n = nums.length) == 0) return;
		// 从后往前查找第一次出现 nums[i] < nums[i+1] 的位置
		int i = n - 2;
		for (; i >= 0 && nums[i] >= nums[i + 1]; i--) ;
		// if i == -1 nums 则整体逆序
		if (i >= 0) {
			// 此时 nums[i+1, n-1] 降序, 查找其中 大于nums[i] 的最大下标，可以直接 从后往前 逆向找
			// 因为有序 可以练习一下二分查找
			int j = binarySearch(nums, i + 1, n - 1, nums[i]);
			// 交换 i j
			swap(nums, i, j);
		}
		// 此时 nums[i+1, n-1] 仍然降序，将其改为升序，只需要反转即可。
		reverse(nums, i + 1, n - 1);
	}

	// nums[left, right] 逆序，查找其中 > target 的 最大下标
	private int binarySearch(int[] nums, int left, int right, int target) {
		while (left <= right) {
			int mid = (left + right) >>> 1;
			if (nums[mid] > target) {
				left = mid + 1; // 尝试再缩小区间
			} else {
				right = mid - 1;
			}
		}
		return right;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i++, j--);
		}
	}
}
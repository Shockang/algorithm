package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode315.solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * 归并排序
 *
 * @author Shockang
 */
public class Solution {
	private int[] count;

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();

		count = new int[nums.length];
		int[] indexes = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			indexes[i] = i;
		}
		mergesort(nums, indexes, 0, nums.length - 1);
		for (int i = 0; i < count.length; i++) {
			res.add(count[i]);
		}
		return res;
	}

	private void mergesort(int[] nums, int[] indexes, int start, int end) {
		if (end <= start) {
			return;
		}
		int mid = (start + end) / 2;
		mergesort(nums, indexes, start, mid);
		mergesort(nums, indexes, mid + 1, end);

		merge(nums, indexes, start, end);
	}

	private void merge(int[] nums, int[] indexes, int start, int end) {
		int mid = (start + end) / 2;
		int left = start;
		int right = mid + 1;
		int rightcount = 0;
		int[] a = new int[end - start + 1];

		int i = 0;
		while (left <= mid && right <= end) {
			if (nums[indexes[right]] < nums[indexes[left]]) {
				a[i] = indexes[right];
				rightcount++;
				right++;
			} else {
				a[i] = indexes[left];
				count[indexes[left]] += rightcount;
				left++;
			}
			i++;
		}
		while (left <= mid) {
			a[i] = indexes[left];
			count[indexes[left]] += rightcount;
			left++;
			i++;
		}
		while (right <= end) {
			a[i++] = indexes[right++];
		}
		for (int j = start; j <= end; j++) {
			indexes[j] = a[j - start];
		}
	}
}

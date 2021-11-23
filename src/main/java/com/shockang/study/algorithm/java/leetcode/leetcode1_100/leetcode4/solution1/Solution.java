package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode4.solution1;

/**
 * 4. 寻找两个正序数组的中位数
 * <p>
 * 二分查找
 *
 * @author Shockang
 */
public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int m = nums1.length, n = nums2.length, left = 0, right = m, leftTotal = (m + n + 1) / 2;

		while (left < right) {
			int i = left + ((right - left + 1) >> 1), j = leftTotal - i;

			if (nums1[i - 1] > nums2[j]) {
				right = i - 1;
			} else {
				left = i;
			}
		}

		int i = left, j = leftTotal - i;

		int nums1LeftMax = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
		int nums1RightMin = (i == m ? Integer.MAX_VALUE : nums1[i]);
		int nums2LeftMax = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
		int nums2RightMin = (j == n ? Integer.MAX_VALUE : nums2[j]);
		if ((m + n) % 2 == 0) {
			return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
		} else {
			return (double) Math.max(nums1LeftMax, nums2LeftMax);
		}
	}
}

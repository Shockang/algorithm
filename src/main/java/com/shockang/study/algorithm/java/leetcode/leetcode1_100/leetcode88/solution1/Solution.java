package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode88.solution1;

/**
 * i，j，k，j 二次判断
 *
 * @author Shockang
 */
public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			int num1 = nums1[i];
			int num2 = nums2[j];
			if (num1 >= num2) {
				nums1[k--] = num1;
				i--;
			} else {
				nums1[k--] = num2;
				j--;
			}
		}
		while (j >= 0) {
			nums1[j] = nums2[j];
			j--;
		}
	}
}
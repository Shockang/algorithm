package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode27.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int removeElement(int[] nums, int val) {
		int j = 0, n = nums.length;
		for (int i = 0; i < n; i++) if (nums[i] != val) nums[j++] = nums[i];
		return j;
	}
}

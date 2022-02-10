package com.shockang.study.algorithm.java.leetcode.leetcode1301_1400.leetcode1365.solution1;

/**
 * 计数排序
 *
 * @author Shockang
 */
public class Solution {
	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] cnt = new int[101];
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			cnt[nums[i]]++;
		}
		for (int i = 1; i <= 100; i++) {
			cnt[i] += cnt[i - 1];
		}
		int[] ret = new int[n];
		for (int i = 0; i < n; i++) {
			ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
		}
		return ret;
	}
}
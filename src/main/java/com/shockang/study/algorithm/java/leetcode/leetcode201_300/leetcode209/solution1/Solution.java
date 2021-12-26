package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode209.solution1;

/**
 * 滑动窗口
 *
 * @author Shockang
 */
public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		int start = 0, end = 0;
		int sum = 0;
		while (end < n) {
			sum += nums[end];
			while (sum >= s) {
				ans = Math.min(ans, end - start + 1);
				sum -= nums[start];
				start++;
			}
			end++;
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode45.solution1;

/**
 * i == end  更新最远距离
 *
 * @author Shockang
 */
public class Solution {
	public int jump(int[] nums) {
		int n = nums.length, max = 0, end = 0, res = 0;
		for (int i = 0; i < n - 1; i++) {
			max = Math.max(max, i + nums[i]);
			if (i == end) {
				end = max;
				res++;
			}
		}
		return res;
	}
}

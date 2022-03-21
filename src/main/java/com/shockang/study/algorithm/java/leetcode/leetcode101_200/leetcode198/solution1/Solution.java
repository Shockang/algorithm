package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode198.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		int prev1 = 0, prev2 = 0;
		for (int num : nums) {
			int tmp = prev1;
			prev1 = Math.max(prev2 + num, prev1);
			prev2 = tmp;
		}
		return prev1;
	}
}
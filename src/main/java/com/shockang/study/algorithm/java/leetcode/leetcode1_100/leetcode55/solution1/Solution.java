package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode55.solution1;

/**
 * if (curMax < i) return false; curMax 代表经过每一个点能到达的最远距离
 *
 * @author Shockang
 */
public class Solution {
	public boolean canJump(int[] nums) {
		int curMax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (curMax < i) return false;
			curMax = Math.max(curMax, i + nums[i]);
		}
		return true;
	}
}

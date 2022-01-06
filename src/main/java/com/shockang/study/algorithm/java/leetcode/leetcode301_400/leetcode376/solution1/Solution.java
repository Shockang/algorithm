package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode376.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int wiggleMaxLength(int[] nums) {
		int n = nums.length;
		if (n < 2) {
			return n;
		}
		int prevdiff = nums[1] - nums[0];
		int ret = prevdiff != 0 ? 2 : 1;
		for (int i = 2; i < n; i++) {
			int diff = nums[i] - nums[i - 1];
			if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
				ret++;
				prevdiff = diff;
			}
		}
		return ret;
	}
}

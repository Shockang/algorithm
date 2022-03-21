package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode136.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int num : nums) {
			res ^= num;
		}
		return res;
	}
}
package com.shockang.study.algorithm.java.leetcode.offer.offer39.solution1;

/**
 * 摩尔投票算法
 *
 * @author Shockang
 */
public class Solution {
	public int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}

		return candidate;
	}
}

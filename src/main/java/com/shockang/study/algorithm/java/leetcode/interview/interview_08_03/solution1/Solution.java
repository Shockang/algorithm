package com.shockang.study.algorithm.java.leetcode.interview.interview_08_03.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int findMagicIndex(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i) {
				return i;
			}
		}
		return -1;
	}
}
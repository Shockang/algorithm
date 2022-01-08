package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode26.solution1;

/**
 * i遍历，j占位
 *
 * @author Shockang
 */
public class Solution {
	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i == 0 || n > nums[i - 1])
				nums[i++] = n;
		return i;
	}
}

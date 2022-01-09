package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode80.solution1;

/**
 * 双指针，一个用来遍历，一个用来占位
 *
 * @author Shockang
 */
public class Solution {
	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}
}
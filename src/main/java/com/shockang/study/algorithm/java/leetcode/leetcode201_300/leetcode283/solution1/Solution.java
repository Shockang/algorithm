package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode283.solution1;

/**
 * i遍历，j占位
 *
 * @author Shockang
 */
public class Solution {
		public void moveZeroes(int[] nums) {
				for (int i = 0, j = 0; i < nums.length; i++) {
						if (nums[i] != 0) {
								if (i != j) {
										nums[j] = nums[i];
										nums[i] = 0;
								}
								j++;
						}
				}
		}
}

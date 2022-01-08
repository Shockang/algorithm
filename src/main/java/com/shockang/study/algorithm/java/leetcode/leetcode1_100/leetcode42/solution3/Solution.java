package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode42.solution3;

/**
 * 双指针 leftMax > rightMax
 *
 * @author Shockang
 */
public class Solution {
	public int trap(int[] height) {
		if (height.length == 0) return 0;
		int n = height.length, left = 0, leftMax = 0, right = n - 1, rightMax = 0, res = 0;
		while (left < right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);
			if (leftMax > rightMax) {
				res += rightMax - height[right];
				right--;
			} else {
				res += leftMax - height[left];
				left++;
			}
		}
		return res;
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode42.solution1;

/**
 * 动态规划 + 3 次遍历
 *
 * @author Shockang
 */
public class Solution {
	public int trap(int[] height) {
		if (height.length == 0) return 0;
		int n = height.length;
		int[] leftMax = new int[n], rightMax = new int[n];
		leftMax[0] = height[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}
		rightMax[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			res += Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		return res;
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode11.solution1;

/**
 * 11. 盛最多水的容器
 * <p>
 * 双指针 leftMax >= rightMax
 *
 * @author Shockang
 */
public class Solution {
	public int maxArea(int[] height) {
		int n = height.length, left = 0, right = n - 1, leftMax = 0, rightMax = 0, max = 0;
		while (left < right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);
			max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
			if (leftMax >= rightMax) {
				right--;
			} else {
				left++;
			}
		}
		return max;
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode11.solution2;

/**
 * 11. 盛最多水的容器
 * <p>
 * 双指针 height[low] > height[high]
 *
 * @author Shockang
 */
public class Solution {
	public int maxArea(int[] height) {
		int maxArea = 0;
		int low = 0, high = height.length - 1;
		while (low < high) {
			maxArea = Math.max(maxArea, Math.min(height[low], height[high]) * (high - low));
			if (height[low] > height[high]) {
				high--;
			} else {
				low++;
			}
		}
		return maxArea;
	}
}

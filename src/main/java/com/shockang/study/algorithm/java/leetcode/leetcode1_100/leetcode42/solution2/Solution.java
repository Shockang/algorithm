package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode42.solution2;

import java.util.ArrayDeque;

/**
 * 单调栈
 *
 * @author Shockang
 */
public class Solution {
	public int trap(int[] height) {
		if (height.length == 0) return 0;
		int n = height.length, res = 0;
		ArrayDeque<Integer> stack = new ArrayDeque<>(n);
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
				int top = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
				int left = stack.peek();
				int width = i - left - 1;
				int h = Math.min(height[i], height[left]) - height[top];
				res += width * h;
			}
			stack.push(i);
		}
		return res;
	}
}

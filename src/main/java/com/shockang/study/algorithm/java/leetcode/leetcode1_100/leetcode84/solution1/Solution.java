package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode84.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 单调栈
 *
 * @author Shockang
 */
public class Solution {
	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		if (n == 1) return heights[0];
		int[] h = new int[n + 2];
		System.arraycopy(heights, 0, h, 1, n);
		Deque<Integer> stack = new ArrayDeque<>(n);
		int max = 0;
		for (int i = 0; i < n + 2; i++) {
			while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
				int height = h[stack.pop()];
				int width = i - stack.peek() - 1;
				max = Math.max(max, width * height);
			}
			stack.push(i);
		}
		return max;
	}
}
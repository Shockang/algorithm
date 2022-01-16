package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode739.solution1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Shockang
 */
public class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] ans = new int[n];
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int t = temperatures[i];
			while (!stack.isEmpty() && t > temperatures[stack.peek()]) {
				int prevIndex = stack.pop();
				ans[prevIndex] = i - prevIndex;
			}
			stack.push(i);
		}
		return ans;
	}
}

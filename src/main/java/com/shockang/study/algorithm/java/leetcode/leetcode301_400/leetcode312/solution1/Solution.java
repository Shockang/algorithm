package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode312.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int maxCoins(int[] nums) {
		int[] a = new int[nums.length + 2];
		int n = 1;
		for (int num : nums) {
			if (num > 0) {
				a[n++] = num;
			}
		}
		a[0] = a[n] = 1;
		return burst(new int[n + 1][n + 1], a, 0, n);
	}

	private int burst(int[][] memory, int[] a, int left, int right) {
		if (left + 1 == right) return 0;
		if (memory[left][right] > 0) return memory[left][right];
		int res = 0;
		for (int i = left + 1; i < right; i++) {
			res = Math.max(res, a[left] * a[i] * a[right] + burst(memory, a, left, i) + burst(memory, a, i, right));
		}
		memory[left][right] = res;
		return res;
	}
}
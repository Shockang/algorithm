package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode135.solution1;

import java.util.Arrays;

/**
 * 动态规划，初始都为 1，左一遍，右一遍
 *
 * @author Shockang
 */
public class Solution {
	public int candy(int[] ratings) {
		int n = ratings.length;
		int[] candies = new int[n];
		Arrays.fill(candies, 1);
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			}
		}
		int sum = candies[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
			sum += candies[i];
		}
		return sum;
	}
}
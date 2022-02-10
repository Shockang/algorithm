package com.shockang.study.algorithm.java.leetcode.leetcode1501_1600.leetcode1561.solution1;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int maxCoins(int[] piles) {
		Arrays.sort(piles);
		int length = piles.length;
		int rounds = length / 3;
		int coins = 0;
		int index = length - 2;
		for (int i = 0; i < rounds; i++) {
			coins += piles[index];
			index -= 2;
		}
		return coins;
	}
}
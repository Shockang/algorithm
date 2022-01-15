package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode605.solution1;

/**
 * 统计每个间隔
 *
 * @author Shockang
 */
public class Solution {
	private int pre = -1;
	private int len;

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		len = flowerbed.length;
		int max = 0;
		for (int i = 0; i < len; i++) {
			if (flowerbed[i] == 1) {
				max += getMaxBetween(pre, i);
				pre = i;
			}
		}
		max += getMaxBetween(pre, len);
		return n <= max;
	}

	private int getMaxBetween(int i1, int i2) {
		if (i1 == -1 && i2 == len) {
			return (i2 + 1) / 2;
		} else if (i1 == -1 || i2 == len) {
			return Math.max((i2 - i1 - 1) / 2, 0);
		} else {
			return Math.max((i2 - i1 - 2) / 2, 0);
		}
	}
}

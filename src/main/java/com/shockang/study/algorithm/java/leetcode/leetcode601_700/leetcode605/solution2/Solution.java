package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode605.solution2;

/**
 * 贪心
 *
 * @author Shockang
 */
public class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		int m = flowerbed.length;
		int prev = -1;
		for (int i = 0; i < m; i++) {
			if (flowerbed[i] == 1) {
				if (prev < 0) {
					count += i / 2;
				} else {
					count += (i - prev - 2) / 2;
				}
				prev = i;
			}
		}
		if (prev < 0) {
			count += (m + 1) / 2;
		} else {
			count += (m - prev - 1) / 2;
		}
		return count >= n;
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode179.solution1;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public String largestNumber(int[] nums) {
		int n = nums.length;
		// 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
		Integer[] numsArr = new Integer[n];
		for (int i = 0; i < n; i++) {
			numsArr[i] = nums[i];
		}

		Arrays.sort(numsArr, (x, y) -> {
			long sx = 10, sy = 10;
			while (sx <= x) {
				sx *= 10;
			}
			while (sy <= y) {
				sy *= 10;
			}
			return (int) (-sy * x - y + sx * y + x);
		});

		if (numsArr[0] == 0) {
			return "0";
		}
		StringBuilder ret = new StringBuilder();
		for (int num : numsArr) {
			ret.append(num);
		}
		return ret.toString();
	}
}
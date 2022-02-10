package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1624.solution2;

/**
 * 双指针
 *
 * @author Shockang
 */
public class Solution {
	public int maxLengthBetweenEqualCharacters(String s) {
		char[] ch = s.toCharArray();
		int l = 0, r = 0, n = ch.length;
		for (int i = 0; i < n; i++) {
			for (l = 0, r = n - i - 1; r < n; r++, l++) {
				if (ch[l] == ch[r]) return r - l - 1;
			}
		}
		return -1;
	}
};
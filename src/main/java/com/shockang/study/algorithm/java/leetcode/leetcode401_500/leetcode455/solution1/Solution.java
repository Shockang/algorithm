package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode455.solution1;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int m = g.length, n = s.length;
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (g[i] > s[j]) j++;
			else {
				i++;
				j++;
			}
		}
		return i;
	}
}
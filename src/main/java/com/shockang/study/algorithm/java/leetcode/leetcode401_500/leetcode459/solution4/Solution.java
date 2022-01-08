package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode459.solution4;

import java.util.Arrays;

/**
 * 优化的 KMP
 *
 * @author Shockang
 */
public class Solution {
	public boolean repeatedSubstringPattern(String s) {
		return kmp(s);
	}

	public boolean kmp(String pattern) {
		int n = pattern.length();
		int[] fail = new int[n];
		Arrays.fill(fail, -1);
		for (int i = 1; i < n; ++i) {
			int j = fail[i - 1];
			while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
				j = fail[j];
			}
			if (pattern.charAt(j + 1) == pattern.charAt(i)) {
				fail[i] = j + 1;
			}
		}
		return fail[n - 1] != -1 && n % (n - fail[n - 1] - 1) == 0;
	}
}
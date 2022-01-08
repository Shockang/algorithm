package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode541.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public String reverseStr(String s, int k) {
		int n = s.length();
		char[] a = s.toCharArray();
		for (int i = 0; i < n; i += 2 * k) {
			reverse(a, i, Math.min(i + k, n) - 1);
		}
		return new String(a);
	}

	private void reverse(char[] a, int l, int r) {
		while (l < r) {
			char tmp = a[l];
			a[l] = a[r];
			a[r] = tmp;
			l++;
			r--;
		}
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode125.solution1;

/**
 * @author Shockang
 */
public class Solution {
	private char[] c;
	private int n;

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		c = s.toCharArray();
		n = c.length;
		return expand(0, n - 1);
	}

	private boolean expand(int i, int j) {
		while (i < j) {
			if (!valid(c[i])) {
				i++;
			} else if (!valid(c[j])) {
				j--;
			} else if (c[i] == c[j]) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean valid(char ch) {
		return ('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9');
	}
}
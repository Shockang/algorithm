package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode680.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public boolean validPalindrome(String s) {
		int l = -1, r = s.length();
		while (++l < --r)
			if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r + 1) || isPalindromic(s, l - 1, r);
		return true;
	}

	public boolean isPalindromic(String s, int l, int r) {
		while (++l < --r)
			if (s.charAt(l) != s.charAt(r)) return false;
		return true;
	}
}

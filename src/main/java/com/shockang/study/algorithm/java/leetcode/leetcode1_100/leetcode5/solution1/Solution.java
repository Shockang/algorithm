package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode5.solution1;

/**
 * 5. 最长回文子串
 * <p>
 * 奇偶 getLen
 *
 * @author Shockang
 */
public class Solution {
	private char[] cs;
	private int n;

	public String longestPalindrome(String s) {
		if (s.length() == 1) return s;
		cs = s.toCharArray();
		n = s.length();
		String res = "";
		for (int i = 0; i < n - 1; i++) {
			int len1 = getLen(i, i);
			int len2 = getLen(i, i + 1);
			if (len1 >= len2 && len1 > res.length()) {
				res = s.substring(i - len1 / 2, i + 1 + len1 / 2);
			} else if (len1 < len2 && len2 > res.length()) {
				res = s.substring(i + 1 - len2 / 2, i + 1 + len2 / 2);
			}
		}
		return res;
	}

	private int getLen(int l, int r) {
		while (l >= 0 && r < n && cs[l] == cs[r]) {
			l--;
			r++;
		}
		return r - l - 1;
	}
}

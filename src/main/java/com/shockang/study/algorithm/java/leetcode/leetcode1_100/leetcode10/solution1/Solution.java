package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode10.solution1;

/**
 * 10. 正则表达式匹配
 * <p>
 * 递归，firstMatch，substring
 *
 * @author Shockang
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) return s.isEmpty();
		if (p.length() == 1) return s.length() == 1 && firstMatch(s, p);
		if (s.isEmpty()) return p.charAt(1) == '*' && isMatch(s, p.substring(2));
		if (p.charAt(1) == '*') {
			return isMatch(s, p.substring(2)) || (firstMatch(s, p) && isMatch(s.substring(1), p));
		} else {
			return firstMatch(s, p) && isMatch(s.substring(1), p.substring(1));
		}
	}

	private boolean firstMatch(String s, String p) {
		return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
	}
}

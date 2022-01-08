package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode44.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		int m = s.length(), n = p.length(), i = 0, j = 0, startJ = -1, lastMatch = -1;
		while (i < m) {
			if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			} else if (j < n && p.charAt(j) == '*') {
				startJ = j;
				j++;
				lastMatch = i;
			} else if (startJ != -1) {
				j = startJ + 1;
				lastMatch++;
				i = lastMatch;
			} else {
				return false;
			}
		}
		while (j < n && p.charAt(j) == '*') {
			j++;
		}
		return j == n;
	}
}

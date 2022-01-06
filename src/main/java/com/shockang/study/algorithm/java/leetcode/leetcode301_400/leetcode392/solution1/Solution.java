package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode392.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public boolean isSubsequence(String s, String t) {
		if (s == null || t == null || s.length() > t.length()) return false;
		if (s.length() == 0) return true;
		int n = t.length();
		int index = 0;
		for (char c : s.toCharArray()) {
			if (index > n) return false;
			index = t.indexOf(c, index);
			if (index == -1) return false;
			index++;
		}
		return index <= n;
	}
}
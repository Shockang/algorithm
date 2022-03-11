package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode392.solution2;

/**
 * @author Shockang
 */
public class Solution {
	public boolean isSubsequence(String s, String t) {
		int n = s.length(), m = t.length();
		int i = 0, j = 0;
		while (i < n && j < m) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == n;
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode459.solution1;

/**
 * 枚举
 *
 * @author Shockang
 */
public class Solution {
	public boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		for (int i = 1; i * 2 <= n; ++i) {
			if (n % i == 0) {
				boolean match = true;
				for (int j = i; j < n; ++j) {
					if (s.charAt(j) != s.charAt(j - i)) {
						match = false;
						break;
					}
				}
				if (match) {
					return true;
				}
			}
		}
		return false;
	}
}

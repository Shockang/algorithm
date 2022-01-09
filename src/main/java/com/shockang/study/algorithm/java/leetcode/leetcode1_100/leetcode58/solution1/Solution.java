package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode58.solution1;

/**
 * ← 遍历
 *
 * @author Shockang
 */
public class Solution {
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) return 0;
		int result = 0, i = s.length() - 1;
		while (i >= 0 && s.charAt(i) == ' ') i--;
		while (i >= 0 && s.charAt(i) != ' ') {
			result++;
			i--;
		}
		return result;
	}
}

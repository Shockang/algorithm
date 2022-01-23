package com.shockang.study.algorithm.java.leetcode.leetcode1001_1100.leetcode1021.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public String removeOuterParentheses(String S) {
		StringBuilder sb = new StringBuilder();
		int level = 0;
		for (char c : S.toCharArray()) {
			if (c == ')') --level;
			if (level >= 1) sb.append(c);
			if (c == '(') ++level;
		}
		return sb.toString();
	}
}
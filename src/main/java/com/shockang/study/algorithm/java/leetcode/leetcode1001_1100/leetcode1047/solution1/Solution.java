package com.shockang.study.algorithm.java.leetcode.leetcode1001_1100.leetcode1047.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public String removeDuplicates(String S) {
		char[] s = S.toCharArray();
		int top = -1;
		for (int i = 0; i < S.length(); i++) {
			if (top == -1 || s[top] != s[i]) {
				s[++top] = s[i];
			} else {
				top--;
			}
		}
		return String.valueOf(s, 0, top + 1);
	}
}
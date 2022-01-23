package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode917.solution2;

/**
 * @author Shockang
 */
public class Solution {
	public String reverseOnlyLetters(String s) {
		char[] cs = s.toCharArray();
		int l = 0, r = cs.length - 1;
		while (l <= r) {
			if (Character.isLetter(cs[l]) && Character.isLetter(cs[r])) {
				char temp = cs[l];
				cs[l] = cs[r];
				cs[r] = temp;
				l++;
				r--;
			} else if (!Character.isLetter(cs[l])) {
				l++;
			} else if (!Character.isLetter(cs[r])) {
				r--;
			}
		}
		return new String(cs);
	}
}
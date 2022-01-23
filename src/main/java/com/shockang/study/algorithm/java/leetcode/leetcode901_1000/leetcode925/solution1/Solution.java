package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode925.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public boolean isLongPressedName(String name, String typed) {
		int i = 0, j = 0;
		while (j < typed.length()) {
			if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
				i++;
				j++;
			} else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
				j++;
			} else {
				return false;
			}
		}
		return i == name.length();
	}
}
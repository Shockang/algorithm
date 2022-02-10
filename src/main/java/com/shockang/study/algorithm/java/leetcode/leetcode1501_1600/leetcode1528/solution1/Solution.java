package com.shockang.study.algorithm.java.leetcode.leetcode1501_1600.leetcode1528.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public String restoreString(String s, int[] indices) {
		int length = s.length();
		char[] result = new char[length];

		for (int i = 0; i < length; i++) {
			result[indices[i]] = s.charAt(i);
		}
		return new String(result);
	}
}

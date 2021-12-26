package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode205.solution1;

/**
 * 512 数组
 *
 * @author Shockang
 */
public class Solution {
	public boolean isIsomorphic(String s1, String s2) {
		int[] m = new int[512];
		for (int i = 0; i < s1.length(); i++) {
			if (m[s1.charAt(i)] != m[s2.charAt(i) + 256]) return false;
			m[s1.charAt(i)] = m[s2.charAt(i) + 256] = i + 1;
		}
		return true;
	}
}
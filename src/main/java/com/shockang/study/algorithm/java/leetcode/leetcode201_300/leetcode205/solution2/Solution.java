package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode205.solution2;

/**
 * 2 个 256 数组
 *
 * @author Shockang
 */
public class Solution {
	public boolean isIsomorphic(String s, String t) {
		char[] chars = s.toCharArray();
		char[] chart = t.toCharArray();
		int[] preIndexOfs = new int[256];
		int[] preIndexOft = new int[256];
		for (int i = 0; i < chars.length; i++) {
			if (preIndexOfs[chars[i]] != preIndexOft[chart[i]]) {
				return false;
			}
			preIndexOfs[chars[i]] = i + 1;
			preIndexOft[chart[i]] = i + 1;
		}
		return true;
	}
}
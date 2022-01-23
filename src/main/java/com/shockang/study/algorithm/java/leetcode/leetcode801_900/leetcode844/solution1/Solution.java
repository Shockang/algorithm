package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode844.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public boolean backspaceCompare(String S, String T) {
		return build(S).equals(build(T));
	}

	public String build(String str) {
		StringBuilder ret = new StringBuilder();
		int length = str.length();
		for (int i = 0; i < length; ++i) {
			char ch = str.charAt(i);
			if (ch != '#') {
				ret.append(ch);
			} else {
				if (ret.length() > 0) {
					ret.deleteCharAt(ret.length() - 1);
				}
			}
		}
		return ret.toString();
	}
}


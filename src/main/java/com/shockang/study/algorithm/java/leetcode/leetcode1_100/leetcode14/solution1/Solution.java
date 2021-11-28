package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode14.solution1;

/**
 * 14. 最长公共前缀
 * <p>
 * 先遍历第一个字符串，再嵌套整个数组，遇到不相等直接返回substring
 *
 * @author Shockang
 */
public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int length = strs[0].length();
		int count = strs.length;
		for (int i = 0; i < length; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < count; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
}

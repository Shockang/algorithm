package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode459.solution2;

/**
 * 字符串匹配
 *
 * @author Shockang
 */
public class Solution {
	public boolean repeatedSubstringPattern(String s) {
		return (s + s).indexOf(s, 1) != s.length();
	}
}

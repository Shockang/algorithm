package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode557.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public String reverseWords(String s) {
		// 根据空格转为数组
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String i : arr) {
			// 当前字符串长度
			int l = i.length();
			char[] as = i.toCharArray();
			// 双指针替换
			for (int j = 0; j < l / 2; j++) {
				char t = as[j];
				as[j] = as[l - j - 1];
				as[l - j - 1] = t;
			}
			sb.append(as);
			sb.append(" ");
		}
		return sb.toString().trim();
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode186.solution1;

/**
 * @author Shockang
 */
public class Solution {

	public void reverseWords(char[] s) {
		// 两次翻转即可，第一次全局翻转，第二次翻转各个单词
		int len = s.length;
		reverse(s, 0, len - 1);

		int start = 0;
		for (int i = 0; i < len; i++) {
			if (s[i] == ' ') {
				// 翻转前面的单词
				reverse(s, start, i - 1);
				start = i + 1;
			}
		}

		// 翻转最后一个单词
		reverse(s, start, len - 1);
	}

	private void reverse(char[] s, int start, int end) {
		while (start < end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
	}
}
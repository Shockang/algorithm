package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode157.solution1;

import com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode157.Reader4;

/**
 * @author Shockang
 */
public class Solution extends Reader4 {
	/**
	 * @param buf Destination buffer
	 * @param n   Number of characters to read
	 * @return The number of actual characters read
	 */
	public int read(char[] buf, int n) {
		int tmp, len = 0;
		char[] buffer = new char[4];
		while ((tmp = read4(buffer)) != 0) {
			for (int i = 0; i < tmp && len < n; i++) {
				buf[len] = buffer[i];
				len++;
			}
		}
		return len;
	}
}
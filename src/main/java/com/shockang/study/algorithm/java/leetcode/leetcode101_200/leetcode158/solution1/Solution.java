package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode158.solution1;

import com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode157.Reader4;

/**
 * @author Shockang
 */
public class Solution extends Reader4 {
	int size = 0;
	int i = 0;
	char[] temp = new char[4];

	/**
	 * @param buf Destination buffer
	 * @param n   Number of characters to read
	 * @return The number of actual characters read
	 */
	public int read(char[] buf, int n) {
		int index = 0;

		while (index < n) {
			if (size == 0) {
				size = read4(temp);
				if (size == 0)
					break;
			}

			while (index < n && i < size) {
				buf[index++] = temp[i++];
			}

			if (i == size) {
				// 说明临时字符数组中的内容已经读完，size置零以便执行下一次read4操作
				i = 0;
				size = 0;
			}
		}

		return index;
	}
}
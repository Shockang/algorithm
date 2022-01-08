package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode28.solution2;

/**
 * RK 算法
 *
 * @author Shockang
 */
public class Solution {
	private int m, n;
	private int[] power;

	public int strStr(String haystack, String needle) {
		int m = haystack.length(), n = needle.length();
		if (n == 0) return 0;
		if (m < n) return -1;
		// power 表示底数为 26，指数为下标的幂
		power = new int[m];
		power[0] = 1;
		for (int i = 1; i < m; i++) {
			power[i] = power[i - 1] * 26;
		}
		char[] s = haystack.toCharArray();
		int h = hash(s, 0, n - 1);
		int target = hash(needle.toCharArray(), 0, n - 1);
		if (target == h) return 0;
		for (int i = 1; i < m - n + 1; i++) {
			h = (h - power[n - 1] * (s[i - 1] - 'a')) * 26 + (s[i + n - 1] - 'a');
			if (target == h) return i;
		}
		return -1;
	}

	/**
	 * 计算字符数组的 hash 值，即 26 进制对应 10 进制整数
	 *
	 * @param c 字符数组
	 * @param l 左边界
	 * @param r 右边界
	 */
	private int hash(char[] c, int l, int r) {
		int res = 0;
		for (int i = r; i >= l; i--) {
			res += (c[i] - 'a') * power[r - i];
		}
		return res;
	}
}
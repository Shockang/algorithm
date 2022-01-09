package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode65.solution1;

/**
 * signCount,hasE,hasNum,hasPoint
 *
 * @author Shockang
 */
public class Solution {
	public boolean isNumber(String s) {
		if (s == null) return false;
		s = s.trim().toLowerCase();
		int n = s.length();
		if (n == 0) return false;
		// 正负号的数目
		int signCount = 0;
		boolean hasE = false, hasNum = false, hasPoint = false;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			// 无效字符
			if (!isValid(c)) return false;
			// 数字总是有效的
			if (c >= '0' && c <= '9') hasNum = true;
			// e 或者 E
			if (c == 'e') {
				// e 不能出现 2 次，并且总有数字在前面
				if (hasE || !hasNum) return false;
				// e 不能是最后一个
				if (i == n - 1) return false;
				hasE = true;
			}
			// 小数
			if (c == '.') {
				// 点 不能出现 2 次，并且不能出现在 e 后面
				if (hasPoint || hasE) return false;
				// if . is the last one, digits must be in front of it, e.g. "7."
				// 如果点在最后，数字必须在前面
				if (i == n - 1 && !hasNum) return false;
				hasPoint = true;
			}
			// 符号
			if (c == '+' || c == '-') {
				// 不超过 2 个符号
				if (signCount == 2) return false;
				// 符号不能是最后一个
				if (i == n - 1) return false;
				// 符号可以出现在中间，当 e 在前面的时候
				if (i > 0 && s.charAt(i - 1) != 'e') return false;
				signCount++;
			}
		}
		return true;
	}

	boolean isValid(char c) {
		return c == '.' || c == '+' || c == '-' || c == 'e' || c >= '0' && c <= '9';
	}
}

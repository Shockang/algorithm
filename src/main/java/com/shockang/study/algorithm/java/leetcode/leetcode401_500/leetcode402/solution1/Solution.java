package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode402.solution1;

/**
 * 单调栈
 *
 * @author Shockang
 */
public class Solution {
	public String removeKdigits(String num, int k) {
		StringBuilder res = new StringBuilder();
		int len = num.length(), n;
		for (int i = 0; i < len; i++) {
			char cur = num.charAt(i);
			while (k > 0 && (n = res.length()) > 0 && res.charAt(n - 1) > cur) {
				res.deleteCharAt(n - 1);
				k--;
			}
			if (res.length() == 0 && cur == '0') continue;
			res.append(cur);
		}
		while (k-- > 0 && res.length() > 0) res.deleteCharAt(res.length() - 1);
		return res.length() == 0 ? "0" : res.toString();
	}
}

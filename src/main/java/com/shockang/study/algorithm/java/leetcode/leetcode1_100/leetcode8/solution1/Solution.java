package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode8.solution1;

/**
 * 8. 字符串转换整数 (atoi)
 * <p>
 * sign+单字符判断
 *
 * @author Shockang
 */
public class Solution {
	public int myAtoi(String str) {
		int index = 0, sign = 1, total = 0;
		//1.trim
		str = str.trim();

		//2. 判空
		if (str.length() == 0) return 0;

		//3. sign 表示正负号
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			sign = str.charAt(index) == '+' ? 1 : -1;
			index++;
		}

		//4. 单字符判断，注意溢出
		while (index < str.length()) {
			int digit = str.charAt(index) - '0';
			if (digit < 0 || digit > 9) break;

			// 溢出处理
			if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			total = 10 * total + digit;
			index++;
		}
		return total * sign;
	}
}

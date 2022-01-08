package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode415.solution1;

/**
 * 除号+百分号+carry+sb
 *
 * @author Shockang
 */
public class Solution {
	public String addStrings(String num1, String num2) {
		int m = num1.length(), n = num2.length(), i = m - 1, j = n - 1, carry = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0 || carry > 0) {
			int sum = (i >= 0 ? (num1.charAt(i--) - '0') : 0) + (j >= 0 ? (num2.charAt(j--) - '0') : 0) + carry;
			carry = sum / 10;
			sb.append(sum % 10);
		}
		return sb.reverse().toString();
	}
}
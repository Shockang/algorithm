package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode43.solution1;

/**
 * m+n数组，第一个数中每一位数和第二个数中每一位数相乘，放到相应位置，然后进位得到结果
 *
 * @author Shockang
 */
public class Solution {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int m = num1.length(), n = num2.length();
		int[] ansArr = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			int x = num1.charAt(i) - '0';
			for (int j = n - 1; j >= 0; j--) {
				int y = num2.charAt(j) - '0';
				ansArr[i + j + 1] += x * y;
			}
		}
		for (int i = m + n - 1; i > 0; i--) {
			ansArr[i - 1] += ansArr[i] / 10;
			ansArr[i] %= 10;
		}
		int index = ansArr[0] == 0 ? 1 : 0;
		StringBuffer ans = new StringBuffer();
		while (index < m + n) {
			ans.append(ansArr[index]);
			index++;
		}
		return ans.toString();
	}
}
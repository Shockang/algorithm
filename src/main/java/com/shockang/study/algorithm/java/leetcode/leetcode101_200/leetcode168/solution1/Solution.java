package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode168.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public String convertToTitle(int columnNumber) {
		StringBuilder sb = new StringBuilder();
		while (columnNumber != 0) {
			columnNumber--;
			sb.append((char) (columnNumber % 26 + 'A'));
			columnNumber /= 26;
		}
		return sb.reverse().toString();
	}
}
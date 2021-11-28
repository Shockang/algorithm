package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode12.solution1;

/**
 * 12. 整数转罗马数字
 * <p>
 * 2个倒序数组，2个 while，sb
 *
 * @author Shockang
 */
public class Solution {
	public String intToRoman(int num) {
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		StringBuilder res = new StringBuilder();
		int index = 0;
		while (index < 13) {
			while (num >= nums[index]) {
				res.append(romans[index]);
				num -= nums[index];
			}
			index++;
		}
		return res.toString();
	}
}

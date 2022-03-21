package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode166.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder result = new StringBuilder();
		String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		result.append(sign);
		result.append(num / den);
		long rem = num % den;
		if (rem == 0)
			return result.toString();
		result.append(".");
		Map<Long, Integer> map = new HashMap(); //store numerator as repetition of same numerator will cause recurring
		while (rem != 0) {
			if (!map.containsKey(rem)) {
				map.put(rem, result.length()); //for a given numerator its (num*10)/den starts from this idx
			} else {
				int idx = map.get(rem);
				return result.substring(0, idx) + "(" + result.substring(idx) + ")";
			}
			rem *= 10;
			result.append(rem / den);
			rem = rem % den;
		}
		return result.toString();
	}
}
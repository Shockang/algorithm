package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode13.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * <p>
 * map，4/9 特殊处理
 *
 * @author Shockang
 */
public class Solution {
	private static Map<Character, Integer> symbolValues = new HashMap<>();

	static {
		symbolValues.put('I', 1);
		symbolValues.put('V', 5);
		symbolValues.put('X', 10);
		symbolValues.put('L', 50);
		symbolValues.put('C', 100);
		symbolValues.put('D', 500);
		symbolValues.put('M', 1000);
	}

	public int romanToInt(String s) {
		int ans = 0;
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			int value = symbolValues.get(s.charAt(i));
			if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
				ans -= value;
			} else {
				ans += value;
			}
		}
		return ans;
	}
}
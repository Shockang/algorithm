package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1624.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class Solution {
	public int maxLengthBetweenEqualCharacters(String s) {
		int max = -1;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				max = Math.max(max, i - map.get(s.charAt(i)) - 1);
			} else {
				map.put(s.charAt(i), i);
			}
		}
		return max;

	}
}
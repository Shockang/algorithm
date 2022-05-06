package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode3.solution2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int n = s.length(), start = 0, end = 0, max = 0;
		for (; end < n; end++) {
			char ch = s.charAt(end);
			if (map.containsKey(ch)) {
				start = Math.max(start, map.get(ch) + 1);
			}
			max = Math.max(max, end - start + 1);
			map.put(ch, end);
		}
		return max;
	}
}
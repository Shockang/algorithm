package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode3.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 哈希表
 *
 * @author Shockang
 */
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0, res = 0;
		for (int j = 0; j < s.length(); j++) {
			char cur = s.charAt(j);
			if (map.containsKey(cur)) {
				i = Math.max(i, map.get(cur));
			}
			res = Math.max(res, j - i + 1);
			map.put(cur, j + 1);
		}
		return res;
	}
}

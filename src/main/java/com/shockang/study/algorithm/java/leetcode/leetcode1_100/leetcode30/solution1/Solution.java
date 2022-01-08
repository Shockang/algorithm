package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode30.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 滑动窗口，两层 map
 *
 * @author Shockang
 */
public class Solution {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s.length() == 0) {
			return res;
		}
		int sn = s.length(), wn = words.length, len = words[0].length();
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		for (int i = 0; i < len; i++) {
			int count = wn, start = i;
			Map<String, Integer> matchMap = new HashMap<>();
			for (int j = i; j < sn; j += len) {
				String sub = s.substring(j, Math.min(j + len, sn));
				if (map.containsKey(sub)) {
					matchMap.put(sub, matchMap.getOrDefault(sub, 0) + 1);
					count--;
					while (matchMap.get(sub) > map.get(sub)) {
						String remove = s.substring(start, start + len);
						start += len;
						matchMap.put(remove, matchMap.get(remove) - 1);
						count += 1;
					}
					if (count == 0) {
						res.add(start);
					}
				} else {
					count = wn;
					start = j + len;
					matchMap.clear();
				}
			}
		}
		return res;
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode140.solution1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Shockang
 */
public class Solution {
	private List<String> dict;
	private Map<String, List<String>> map;

	public List<String> wordBreak(String s, List<String> wordDict) {
		dict = wordDict;
		map = new HashMap<>();
		return dfs(s);
	}

	private List<String> dfs(String s) {
		if (map.containsKey(s))
			return map.get(s);

		List<String> res = new LinkedList<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : dict) {
			if (s.startsWith(word)) {
				List<String> sublist = dfs(s.substring(word.length()));
				for (String sub : sublist)
					res.add(word + (sub.isEmpty() ? "" : " ") + sub);
			}
		}
		map.put(s, res);
		return res;
	}
}
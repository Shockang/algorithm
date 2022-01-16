package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode696.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public int countBinarySubstrings(String s) {
		List<Integer> counts = new ArrayList<>();
		int i = 0, n = s.length();
		while (i < n) {
			char c = s.charAt(i);
			int count = 0;
			while (i < n && s.charAt(i) == c) {
				++i;
				++count;
			}
			counts.add(count);
		}
		int ans = 0;
		for (int j = 1; j < counts.size(); ++j) {
			ans += Math.min(counts.get(j), counts.get(j - 1));
		}
		return ans;
	}
}

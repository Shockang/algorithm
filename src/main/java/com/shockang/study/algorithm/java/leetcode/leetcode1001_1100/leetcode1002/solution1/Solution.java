package com.shockang.study.algorithm.java.leetcode.leetcode1001_1100.leetcode1002.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<String> commonChars(String[] A) {
		List<String> ans = new ArrayList<>();
		int[] count = new int[26];
		Arrays.fill(count, Integer.MAX_VALUE);
		for (String str : A) {
			int[] cnt = new int[26];
			str.chars().forEach(c -> ++cnt[c - 'a']);
			for (int i = 0; i < 26; ++i) {
				count[i] = Math.min(cnt[i], count[i]);
			}
		}
		for (char c = 'a'; c <= 'z'; ++c) {
			while (count[c - 'a']-- > 0) {
				ans.add("" + c);
			}
		}
		return ans;
	}
}
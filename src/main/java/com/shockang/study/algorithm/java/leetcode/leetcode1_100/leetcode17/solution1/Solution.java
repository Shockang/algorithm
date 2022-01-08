package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode17.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯+sb
 *
 * @author Shockang
 */
public class Solution {
	String[] letters = {"*", "#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0) return res;
		StringBuilder path = new StringBuilder(digits.length());
		backtracking(path, res, digits, 0);
		return res;
	}

	private void backtracking(StringBuilder path, List<String> res, String digits, int index) {
		if (index == digits.length()) {
			res.add(path.toString());
			return;
		}
		char c = digits.charAt(index);
		int pos = c - '0';
		String map_string = letters[pos];
		for (int i = 0; i < map_string.length(); i++) {
			path.append(map_string.charAt(i));
			backtracking(path, res, digits, index + 1);
			path.deleteCharAt(path.length() - 1);
		}
	}
}

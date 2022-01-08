package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode17.solution2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty()) return ans;
		String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while (ans.peek().length() != digits.length()) {
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length()) - '0'];
			for (char c : map.toCharArray()) {
				ans.addLast(remove + c);
			}
		}
		return ans;
	}
}
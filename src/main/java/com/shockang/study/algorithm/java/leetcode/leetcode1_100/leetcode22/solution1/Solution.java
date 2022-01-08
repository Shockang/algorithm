package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode22.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * left ，right ， char[]，left < sum，left > right
 *
 * @author Shockang
 */
public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(res, new char[2 * n], 0, n, 0, 0);
		return res;
	}

	private void helper(List<String> list, char[] chars, int index, int sum, int left, int right) {
		if (index == 2 * sum) {
			list.add(new String(chars));
			return;
		}
		if (left < sum) {
			chars[index] = '(';
			helper(list, chars, index + 1, sum, left + 1, right);
		}
		if (left > right) {
			chars[index] = ')';
			helper(list, chars, index + 1, sum, left, right + 1);
		}
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode36.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * set，j/3+b+i/3，左j右i
 *
 * @author Shockang
 */
public class Solution {
	public boolean isValidSudoku(char[][] board) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				String s = "(" + board[i][j] + ")";
				if (!set.add(s + i) || !set.add(j + s) || !set.add(j / 3 + s + i / 3)) {
					return false;
				}
			}
		}
		return true;
	}
}

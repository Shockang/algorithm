package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode79.solution1;

/**
 * 小岛沉没
 *
 * @author Shockang
 */
public class Solution {
	public boolean exist(char[][] board, String word) {
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (board[x][y] == word.charAt(0) && helper(board, word, 0, x, y)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean helper(char[][] board, String word, int index, int x, int y) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)) {
			return false;
		}
		if (index == word.length() - 1) {
			return true;
		}
		board[x][y] = '*';
		boolean res = helper(board, word, index + 1, x + 1, y) ||
				helper(board, word, index + 1, x - 1, y) ||
				helper(board, word, index + 1, x, y + 1) ||
				helper(board, word, index + 1, x, y - 1);
		board[x][y] = word.charAt(index);
		return res;
	}
}

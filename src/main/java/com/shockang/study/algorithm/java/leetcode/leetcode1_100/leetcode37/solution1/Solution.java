package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode37.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	//(i,j)=true表示数字j+1在第i+1行是否出现，同一行不可重复
	private boolean[][] rows = new boolean[9][9];
	//(i,j)=true表示数字j+1在第i+1列是否出现，同一列不可重复
	private boolean[][] cols = new boolean[9][9];
	//(i,j,k)=true表示数字k+1在第i+1横块第j+1竖块是否出现，同一3*3块内不可重复
	private boolean[][][] blocks = new boolean[3][3][9];
	//表示当前解法是否有效
	private boolean valid = false;
	//用来存储空白格位置的列表，列表里面每个元素表示空白格坐标组成的一维数组，方便递归
	private List<int[]> spaces = new ArrayList<int[]>();

	/**
	 * 解数独
	 *
	 * @param board 数独
	 */
	public void solveSudoku(char[][] board) {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				//判断是否是空白格
				if (board[i][j] == '.') {
					spaces.add(new int[]{i, j});
				} else {
					appear(i, j, board[i][j] - '1', true);
				}
			}
		}
		//此时已经知道哪些行列块哪些数字都已经出现，开始解决数独中的空白格
		backtracking(board, 0);
	}

	/**
	 * 回溯解决数独中的空白格
	 *
	 * @param board 数独
	 * @param pos   空白格数组索引
	 */
	private void backtracking(char[][] board, int pos) {
		//终止条件，pos == spaces.length 说明此时空白格都已经解决了，结果必然有效
		if (pos == spaces.size()) {
			valid = true;
			return;
		}
		//获取当前空白格坐标
		int[] space = spaces.get(pos);
		int i = space[0], j = space[1];
		//从1到9一个个判断，并且需要满足当前还未求得解
		for (int digit = 0; digit < 9 && !valid; ++digit) {
			//如果当前行当前列当前块都不存在该数字
			if (!rows[i][digit] && !cols[j][digit] && !blocks[i / 3][j / 3][digit]) {
				//我们先让这个数字出现
				appear(i, j, digit, true);
				board[i][j] = (char) (digit + '1');
				//接着进行回溯
				backtracking(board, pos + 1);
				//回溯最后一定要记得恢复
				appear(i, j, digit, false);
			}
		}
	}

	/**
	 * 表示坐标为 (i,j) 时数字 digit+1 是否已经出现
	 *
	 * @param i     第i+1行
	 * @param j     第j+1列
	 * @param digit 数字digit+1
	 * @param flag  是否出现，默认已经出现
	 */
	private void appear(int i, int j, int digit, boolean flag) {
		rows[i][digit] = cols[j][digit] = blocks[i / 3][j / 3][digit] = flag;
	}
}
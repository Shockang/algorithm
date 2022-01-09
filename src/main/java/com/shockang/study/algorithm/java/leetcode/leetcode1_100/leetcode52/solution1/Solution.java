package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode52.solution1;

/**
 * DFS + 位运算剪枝
 *
 * @author Shockang
 */
public class Solution {
	private int ans = 0;

	public int totalNQueens(int n) {
		dfs(n, 0, 0, 0, 0);
		return ans;
	}

	private void dfs(int n, int row, int col, int ld, int rd) {
		if (row >= n) {
			ans++;
			return;
		}
		// (1 << n) - 1
		// 生成了n个1，这里的1表示可以放置皇后，其实就是初始化了n个1，在不考虑皇后之间可以相互攻击的情况下，n个位置都可以放皇后
		// ~(col | ld | rd)
		// 三个变量分别代表了列以及两个斜线的放置情况。
		// 这里的1表示的是不能放置皇后(就是相应的列或斜线上已经放置过皇后了)
		// 因此 int bits = ~(col | ld | rd) & ((1 << n) - 1); 表示的是考虑了相应列、斜线后能放置皇后的位置。
		int bits = ~(col | ld | rd) & ((1 << n) - 1);   // 1
		// bits > 0
		// 当bits>0时，说明bits中还有1存在，就说明遍历还没有完成。
		// 而在之后的循环体中，每遍历bits中的一个1，就会将其清0，这就是代码中注释部分 5 的语句。
		while (bits > 0) {   // 2
			// pick
			// 这里的 pick 就是取出了最后一位1，表示此时遍历的是这种情况。
			// 假设 bits 为0110，取出最后一位1后，就变为0010，就是将皇后放在第3个位置。
			int pick = bits & -bits; // 3
			// col | pick
			// 就是把目前所有放置皇后的列都计算出来了，比如最开始计算时col是0000，pick是0010,那么col | pick就是0010，
			// 意思就是第三列被放置过了。
			//(ld | pick) << 1
			// 假设ld是0000，ld | pick就是0010，左移1位后变成了0100，意思就是下一行的第二列也不要放皇后了，
			// 因为在这一行的第三列我已经放过了，他们是位于一个斜线上的。
			// (rd | pick) >> 1
			// 跟(ld | pick) << 1是一个含义
			dfs(n, row + 1, col | pick, (ld | pick) << 1, (rd | pick) >> 1); //4
			bits &= bits - 1; // 5
		}
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode51.solution1;

import java.util.*;

/**
 * 3个set,i,row+i,row-i
 *
 * @author Shockang
 */
public class Solution {
	private int n;
	private Set<Integer> col = new HashSet<>(), diagonal1 = new HashSet<>(), diagonal2 = new HashSet<>();

	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		List<List<String>> res = new ArrayList<>();
		backtracking(res, new ArrayList<>(), 0);
		return res;
	}

	private void backtracking(List<List<String>> list, List<String> tmp, int row) {
		if (row == n) {
			list.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (col.contains(i) || diagonal1.contains(row + i) || diagonal2.contains(row - i)) {
				continue;
			}
			char[] a = new char[n];
			Arrays.fill(a, '.');
			a[i] = 'Q';
			tmp.add(new String(a));
			col.add(i);
			diagonal1.add(row + i);
			diagonal2.add(row - i);
			backtracking(list, tmp, row + 1);
			tmp.remove(tmp.size() - 1);
			col.remove(i);
			diagonal1.remove(row + i);
			diagonal2.remove(row - i);
		}
	}
}

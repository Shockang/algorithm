package com.shockang.study.algorithm.java.leetcode.leetcode1001_1100.leetcode1020.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * 回溯，小岛沉没
 *
 * @author Shockang
 */
public class Solution {
	private int[][] g;
	private int m, n;

	public int numEnclaves(int[][] grid) {
		g = grid;
		m = grid.length;
		n = grid[0].length;
		int ans = 0;
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (g[x][y] == 1) {
					if (sink(new HashSet<>(), x, y)) {
						ans++;
					}
				}
			}
		}
		return ans;
	}

	private boolean sink(Set<String> set, int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n || g[x][y] == 0 || set.contains(x + "," + y)) return true;
		if (x == 0 || x == m - 1 || y == 0 || y == n - 1) return false;
		set.add(x + "," + y);
		g[x][y] = 0;
		boolean res = sink(set, x - 1, y) && sink(set, x + 1, y) && sink(set, x, y - 1) && sink(set, x, y + 1);
		g[x][y] = 1;
		return res;
	}
}

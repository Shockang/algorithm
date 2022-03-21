package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode200.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int count = 0;
		Set<String> set = new HashSet<>();
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[0].length; y++) {
				if (grid[x][y] == '1') {
					sink(grid, set, x, y);
					count++;
				}
			}
		}
		return count;
	}

	private void sink(char[][] grid, Set<String> set, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || set.contains(x + "," + y)) {
			return;
		}
		grid[x][y] = '0';
		set.add(x + "," + y);
		sink(grid, set, x + 1, y);
		sink(grid, set, x - 1, y);
		sink(grid, set, x, y + 1);
		sink(grid, set, x, y - 1);
	}
}
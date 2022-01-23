package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode841.solution2;

import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	boolean[] vis;
	int num;

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size();
		num = 0;
		vis = new boolean[n];
		dfs(rooms, 0);
		return num == n;
	}

	public void dfs(List<List<Integer>> rooms, int x) {
		vis[x] = true;
		num++;
		for (int it : rooms.get(x)) {
			if (!vis[it]) {
				dfs(rooms, it);
			}
		}
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode841.solution3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Shockang
 */
public class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size(), num = 0;
		boolean[] vis = new boolean[n];
		Queue<Integer> que = new LinkedList<>();
		vis[0] = true;
		que.offer(0);
		while (!que.isEmpty()) {
			int x = que.poll();
			num++;
			for (int it : rooms.get(x)) {
				if (!vis[it]) {
					vis[it] = true;
					que.offer(it);
				}
			}
		}
		return num == n;
	}
}
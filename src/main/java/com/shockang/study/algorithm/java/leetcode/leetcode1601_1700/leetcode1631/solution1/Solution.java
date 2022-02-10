package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1631.solution1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Shockang
 */
public class Solution {
	int[] DIR = new int[]{0, 1, 0, -1, 0};

	public int minimumEffortPath(int[][] heights) {
		int m = heights.length, n = heights[0].length;
		int[][] dist = new int[m][n];
		for (int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		minHeap.offer(new int[]{0, 0, 0}); // distance, row, col
		while (!minHeap.isEmpty()) {
			int[] top = minHeap.poll();
			int d = top[0], r = top[1], c = top[2];
			if (r == m - 1 && c == n - 1) return d;
			for (int i = 0; i < 4; i++) {
				int nr = r + DIR[i], nc = c + DIR[i + 1];
				if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
					int newDist = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
					if (dist[nr][nc] > newDist) {
						dist[nr][nc] = newDist;
						minHeap.offer(new int[]{dist[nr][nc], nr, nc});
					}
				}
			}
		}
		return 0;
	}
}
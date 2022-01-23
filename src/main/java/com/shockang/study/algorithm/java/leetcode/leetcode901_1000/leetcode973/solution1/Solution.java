package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode973.solution1;

import java.util.PriorityQueue;

/**
 * @author Shockang
 */
public class Solution {
	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		for (int[] coords : points) queue.add(new Point(coords));
		int[][] res = new int[K][2];
		Point cur;
		while (K > 0) {
			cur = queue.remove();
			res[K - 1][0] = cur.x;
			res[K - 1][1] = cur.y;
			K--;
		}
		return res;
	}


	private static class Point implements Comparable<Point> {
		int x;
		int y;

		Point(int[] coords) {
			this.x = coords[0];
			this.y = coords[1];
		}

		@Override
		public int compareTo(Point p) {
			return Integer.compare(x * x + y * y, p.x * p.x + p.y * p.y);
		}
	}
}
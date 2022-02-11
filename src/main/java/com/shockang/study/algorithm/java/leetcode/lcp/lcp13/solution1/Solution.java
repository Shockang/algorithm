package com.shockang.study.algorithm.java.leetcode.lcp.lcp13.solution1;

import java.util.*;

/**
 * @author Shockang
 */
public class Solution {
	private int[][] dist;
	private Queue<Point> queue;
	private int[] dir = {-1, 0, 1, 0, -1};  // 压缩方向数组，二维变一维, {-1,0},{0,1},{1,0},{0,-1}
	private int n;
	private int m;
	private int[][] tsDist; // trigger to stone dist
	private int[][] ttDist;  // trigger to trigger dist
	private int[][] f;
	private int INF = 0x3f3f3f3f;

	public int minimalSteps(String[] maze) {
		this.n = maze.length;
		this.m = maze[0].length();
		dist = new int[150][150];
		tsDist = new int[20][45];
		ttDist = new int[20][20];
		f = new int[20][1 << 16];
		queue = new LinkedList<>();

		Point startPoint = null;
		Point endPoint = null;
		List<Point> stones = new ArrayList<>();
		List<Point> triggers = new ArrayList<>();

		// 为了方便, string maze -> matrix
		char[][] mat = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = maze[i].charAt(j);
			}
		}
		// init maze
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == 'S') {
					startPoint = new Point(i, j);
					mat[i][j] = '.';
					continue;
				}
				if (mat[i][j] == 'T') {
					endPoint = new Point(i, j);
					mat[i][j] = '.';
					continue;
				}
				if (mat[i][j] == 'O') {
					stones.add(new Point(i, j));
					mat[i][j] = '.';
					continue;
				}
				if (mat[i][j] == 'M') {
					triggers.add(new Point(i, j));
					mat[i][j] = '.';
				}
			}
		}

		// 起点(S) -> 石堆 -> 机关 -> 石堆 -> 机关 ... -> 石堆 -> 机关 -> 终点(T)
		// 更为统一的: 把起点认为是机关, 终点认为是石堆, 比较方便
		// 机关(S) -> 石堆 -> 机关 -> 石堆 -> 机关 ... -> 石堆 -> 机关 -> 石堆
		triggers.add(startPoint);
		stones.add(endPoint);

		int p = stones.size() - 1;
		int q = triggers.size() - 1;

		// 初始化 tsDist 数组: 计算任意一个机关(trigger) i 到任意一个石堆(stone) j 的距离
		for (int i = 0; i <= q; i++) {
			for (int j = 0; j <= p; j++) {
				tsDist[i][j] = bfs(triggers.get(i), stones.get(j), mat);
			}
		}

		// 初始化 ttDist 数组：当前位于第 i 个机关，下一步要开启第 j 个机关，最少要走多少步
		// 即第 i 个机关走向某个石堆 k，再从该石堆走向机关 j 的步数, floyd
		for (int i = 0; i <= q; i++) {
			for (int j = 0; j <= q; j++) {
				ttDist[i][j] = INF;
				// 枚举石堆, 不算终点
				for (int k = 0; k < p; k++) {
					if (tsDist[i][k] == -1 || tsDist[j][k] == -1) continue;
					int cost = tsDist[i][k] + tsDist[j][k];
					ttDist[i][j] = Math.min(ttDist[i][j], cost);
				}
			}
		}

		// 初始化 dp 数组
		for (int[] a : f) {
			Arrays.fill(a, -1);
		}
		// 最后一个起点0表示未开启。
		f[q][0] = 0;

		// 枚举机关所有状态 staus
		int lim = 1 << q;
		for (int s = 0; s < lim; s++) {
			// 枚举位于第 i 个机关
			for (int i = 0; i <= q; i++) {
				if (f[i][s] == -1) continue;
				// 枚举下一步开启机关 j
				for (int j = 0; j < q; j++) {
					// 相同机关, 继续
					if (i == j) continue;
					// 机关被开启了, 继续
					if (((s >> j) & 1) != 0) continue;
					// 第i个机关到第j个机关走不通, 继续
					if (ttDist[i][j] == INF) continue;
					int cost = ttDist[i][j];
					int ns = s | (1 << j);
					if (f[j][ns] == -1 || f[j][ns] > f[i][s] + cost) {
						f[j][ns] = f[i][s] + cost;
					}
				}
			}
		}

		int res = INF;
		for (int i = 0; i <= q; i++) {
			if (f[i][lim - 1] == -1) {
				continue;
			}
			if (tsDist[i][p] == -1) {
				continue;
			}
			int cur = f[i][lim - 1] + tsDist[i][p];
			res = Math.min(res, cur);
		}
		return res == INF ? -1 : res;
	}


	/**
	 * BFS: 从给定起点到给定终点最少需要走多少步
	 *
	 * @param from 起点
	 * @param to   终点
	 * @return 步数
	 */
	private int bfs(Point from, Point to, char[][] maze) {
		// 特判: 如果是墙壁, 返回-1
		if (maze[from.x][from.y] == '#') {
			return -1;
		}
		// 初始化 dist 数组
		for (int[] a : dist) {
			Arrays.fill(a, -1);
		}
		queue.offer(from);
		dist[from.x][from.y] = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i];
				int ny = y + dir[i + 1];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || maze[nx][ny] == '#') continue;
				if (dist[nx][ny] == -1) {
					dist[nx][ny] = dist[x][y] + 1;
					queue.offer(new Point(nx, ny));
				}
			}
		}
		return dist[to.x][to.y];
	}

}

class Point {
	int x, y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
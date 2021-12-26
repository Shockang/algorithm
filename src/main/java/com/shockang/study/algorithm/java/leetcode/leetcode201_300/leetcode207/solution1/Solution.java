package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode207.solution1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS
 *
 * @author Shockang
 */
public class Solution {
	// 边列表，和 numCourses 一一对应
	List<List<Integer>> edges;
	// 入度数组，和 numCourses 一一对应
	int[] indeg;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) return false;
		edges = new ArrayList<>();
		for (int i = 0; i < numCourses; ++i) {
			edges.add(new ArrayList<>());
		}
		indeg = new int[numCourses];
		for (int[] info : prerequisites) {
			// [1,0] 表示 学习课程 1 之前，你需要完成课程 0
			edges.get(info[1]).add(info[0]);
			// 课程 1 的入度加 1
			++indeg[info[0]];
		}

		// 先遍历出那些可以直接学习的课程
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; ++i) {
			if (indeg[i] == 0) {
				queue.offer(i);
			}
		}

		// 记录访问过的课程数量
		int visited = 0;
		while (!queue.isEmpty()) {
			++visited;
			// 队列里面都是可以直接学习的
			int u = queue.poll();
			for (int v : edges.get(u)) {
				// 既然前面的课程已经学习了，对应的入度减一
				--indeg[v];
				// 入度为 0，代表可以直接学习，加入队列
				if (indeg[v] == 0) {
					queue.offer(v);
				}
			}
		}

		// 确保所有课程都已经访问过了，即都学习过了
		return visited == numCourses;
	}
}

package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode210.solution1;

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
	// indeg 表示入度数组，order 用来记录最终学习顺序的结果
	int[] indeg, order;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) return null;
		edges = new ArrayList<>();
		for (int i = 0; i < numCourses; ++i) {
			edges.add(new ArrayList<>());
		}
		indeg = new int[numCourses];
		order = new int[numCourses];
		// index 表示学习的顺序，对应 order 数组的下标
		int index = 0;
		for (int[] info : prerequisites) {
			// [1,0] 表示 学习课程 1 之前，你需要完成课程 0
			edges.get(info[1]).add(info[0]);
			// 课程 1 的入度加 1
			++indeg[info[0]];
		}

		// 先找到那些可以直接学习的课程，放入队列
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indeg[i] == 0) {
				order[index++] = i;
				queue.offer(i);
			}
		}


		while (!queue.isEmpty()) {
			// 队列里面都是可以直接学习的，取出队列代表已经学习完成了
			int u = queue.poll();
			for (int v : edges.get(u)) {
				// 既然前面的课程已经学习了，对应的入度减一
				--indeg[v];
				// 入度为 0，代表可以直接学习，加入队列
				if (indeg[v] == 0) {
					order[index++] = v;
					queue.offer(v);
				}
			}
		}

		return (index == numCourses) ? order : new int[0];
	}
}
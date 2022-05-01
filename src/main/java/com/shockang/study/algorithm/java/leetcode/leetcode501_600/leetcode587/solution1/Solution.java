package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode587.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public int[][] outerTrees(int[][] trees) {
		int n = trees.length;
		if (n < 4) {
			return trees;
		}
		/* 按照 x 大小进行排序，如果 x 相同，则按照 y 的大小进行排序 */
		Arrays.sort(trees, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});
		List<Integer> hull = new ArrayList<Integer>();
		boolean[] used = new boolean[n];
		/* hull[0] 需要入栈两次，不进行标记 */
		hull.add(0);
		/* 求出凸包的下半部分 */
		for (int i = 1; i < n; i++) {
			while (hull.size() > 1 && cross(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
				used[hull.get(hull.size() - 1)] = false;
				hull.remove(hull.size() - 1);
			}
			used[i] = true;
			hull.add(i);
		}
		int m = hull.size();
		/* 求出凸包的上半部分 */
		for (int i = n - 2; i >= 0; i--) {
			if (!used[i]) {
				while (hull.size() > m && cross(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
					used[hull.get(hull.size() - 1)] = false;
					hull.remove(hull.size() - 1);
				}
				used[i] = true;
				hull.add(i);
			}
		}
		/* hull[0] 同时参与凸包的上半部分检测，因此需去掉重复的 hull[0] */
		hull.remove(hull.size() - 1);
		int size = hull.size();
		int[][] res = new int[size][2];
		for (int i = 0; i < size; i++) {
			res[i] = trees[hull.get(i)];
		}
		return res;
	}

	public int cross(int[] p, int[] q, int[] r) {
		return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
	}
}
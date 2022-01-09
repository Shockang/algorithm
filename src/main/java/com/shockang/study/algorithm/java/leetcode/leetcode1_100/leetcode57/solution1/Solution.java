package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode57.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * pre[1] < cur[0] / pre[0] > cur[1]
 *
 * @author Shockang
 */
public class Solution {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> list = new ArrayList<>();
		int[] pre = newInterval;
		for (int[] cur : intervals) {
			if (pre[1] < cur[0]) {
				list.add(pre);
				pre = cur;
			} else if (pre[0] > cur[1]) {
				list.add(cur);
			} else {
				pre[0] = Math.min(pre[0], cur[0]);
				pre[1] = Math.max(pre[1], cur[1]);
			}
		}
		list.add(pre);
		return list.toArray(new int[0][0]);
	}
}

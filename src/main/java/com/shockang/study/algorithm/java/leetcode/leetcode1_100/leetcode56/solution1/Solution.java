package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode56.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * (prev == null || cur[0] > prev[1]) / cur[1] > prev[1]
 *
 * @author Shockang
 */
public class Solution {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		List<int[]> ret = new ArrayList<>();
		int[] prev = null;
		for (int[] cur : intervals) {
			//如果 prev 是 null 或者 cur.start > prev.end，加入结果集
			if (prev == null || cur[0] > prev[1]) {
				ret.add(cur);
				prev = cur;
			} else if (cur[1] > prev[1]) {
				// cur.end > prev.end，修改列表中存在的元素
				prev[1] = cur[1];
			}
		}
		return ret.toArray(new int[ret.size()][2]);
	}
}

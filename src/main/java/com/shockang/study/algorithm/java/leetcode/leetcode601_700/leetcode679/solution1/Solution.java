package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode679.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 *
 * @author Shockang
 */
public class Solution {
	static final int TARGET = 24;
	static final double EPSILON = 1e-6;
	static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

	public boolean judgePoint24(int[] nums) {
		List<Double> list = new ArrayList<>();
		for (int num : nums) {
			list.add((double) num);
		}
		return solve(list);
	}

	public boolean solve(List<Double> list) {
		if (list.size() == 0) {
			return false;
		}
		if (list.size() == 1) {
			return Math.abs(list.get(0) - TARGET) < EPSILON;
		}
		int size = list.size();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != j) {
					List<Double> list2 = new ArrayList<>();
					for (int k = 0; k < size; k++) {
						if (k != i && k != j) {
							list2.add(list.get(k));
						}
					}
					for (int k = 0; k < 4; k++) {
						if (k < 2 && i > j) {
							continue;
						}
						if (k == ADD) {
							list2.add(list.get(i) + list.get(j));
						} else if (k == MULTIPLY) {
							list2.add(list.get(i) * list.get(j));
						} else if (k == SUBTRACT) {
							list2.add(list.get(i) - list.get(j));
						} else if (k == DIVIDE) {
							if (Math.abs(list.get(j)) < EPSILON) {
								continue;
							} else {
								list2.add(list.get(i) / list.get(j));
							}
						}
						if (solve(list2)) {
							return true;
						}
						list2.remove(list2.size() - 1);
					}
				}
			}
		}
		return false;
	}
}

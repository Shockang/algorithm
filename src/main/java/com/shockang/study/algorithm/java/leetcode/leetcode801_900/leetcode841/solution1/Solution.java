package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode841.solution1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 回溯
 *
 * @author Shockang
 */
public class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int N = rooms.size();
		Set<Integer> set = new HashSet<>(N);
		helper(rooms, set, 0);
		return check(set, N);
	}

	private void helper(List<List<Integer>> rooms, Set<Integer> set, int index) {
		if (set.contains(index)) {
			return;
		}
		set.add(index);
		rooms.get(index).forEach(x -> helper(rooms, set, x));
	}

	private boolean check(Set<Integer> set, int N) {
		for (int i = 1; i < N; i++) {
			if (!set.contains(i)) {
				return false;
			}
		}
		return true;
	}
}

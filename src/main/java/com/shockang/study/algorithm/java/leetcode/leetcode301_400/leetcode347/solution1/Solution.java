package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode347.solution1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Shockang
 */
public class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
		map.forEach((num, count) -> {
			if (queue.size() == k) {
				if (queue.peek()[1] < count) {
					queue.poll();
					queue.offer(new int[]{num, count});
				}
			} else {
				queue.offer(new int[]{num, count});
			}
		});
		int[] res = new int[k];
		for (int i = 0; i < k; ++i) {
			res[i] = queue.poll()[0];
		}
		return res;
	}
}

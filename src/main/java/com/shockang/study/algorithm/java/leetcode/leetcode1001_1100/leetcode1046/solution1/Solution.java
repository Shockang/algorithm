package com.shockang.study.algorithm.java.leetcode.leetcode1001_1100.leetcode1046.solution1;

import java.util.PriorityQueue;

/**
 * @author Shockang
 */
public class Solution {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int stone : stones) {
			pq.offer(stone);
		}

		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			if (a > b) {
				pq.offer(a - b);
			}
		}
		return pq.isEmpty() ? 0 : pq.poll();
	}
}
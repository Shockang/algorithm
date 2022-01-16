package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode703.solution1;

import java.util.PriorityQueue;

/**
 * @author Shockang
 */
public class KthLargest {
	PriorityQueue<Integer> pq;
	int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		pq = new PriorityQueue<>();
		for (int x : nums) {
			add(x);
		}
	}

	public int add(int val) {
		pq.offer(val);
		if (pq.size() > k) {
			pq.poll();
		}
		return pq.peek();
	}
}
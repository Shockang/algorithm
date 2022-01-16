package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode692.solution1;

import java.util.*;

/**
 * @author Shockang
 */
public class Solution {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> cnt = new HashMap<>();
		for (String word : words) {
			cnt.put(word, cnt.getOrDefault(word, 0) + 1);
		}
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) ->
				Objects.equals(e1.getValue(), e2.getValue()) ? e2.getKey().compareTo(e1.getKey()) : e1.getValue() - e2.getValue());
		for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
			pq.offer(entry);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		List<String> ret = new ArrayList<>();
		while (!pq.isEmpty()) {
			ret.add(pq.poll().getKey());
		}
		Collections.reverse(ret);
		return ret;
	}
}

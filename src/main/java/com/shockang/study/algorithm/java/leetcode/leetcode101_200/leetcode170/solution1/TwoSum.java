package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode170.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class TwoSum {
	Map<Integer, Integer> times;

	public TwoSum() {
		times = new HashMap<>();
	}

	public void add(int number) {
		times.put(number, times.getOrDefault(number, 0) + 1);
	}

	public boolean find(int value) {
		for (Integer key : times.keySet()) {
			int last = value - key;
			int cnt = times.getOrDefault(last, 0);
			if (cnt >= 2 || (last != key && cnt == 1))
				return true;
		}
		return false;
	}
}

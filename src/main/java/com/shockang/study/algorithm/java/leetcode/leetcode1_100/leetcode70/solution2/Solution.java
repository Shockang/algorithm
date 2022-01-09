package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode70.solution2;

import java.util.HashMap;
import java.util.Map;

/**
 * map
 *
 * @author Shockang
 */
public class Solution {
	private Map<Integer, Integer> map = new HashMap<>();

	public int climbStairs(int n) {
		if (n < 4) return n;
		if (map.containsKey(n)) return map.get(n);
		int res = climbStairs(n - 2) + climbStairs(n - 1);
		map.put(n, res);
		return res;
	}
}
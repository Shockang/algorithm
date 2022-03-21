package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode149.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class Solution {
	public int maxPoints(int[][] points) {
		if (points.length < 3) return points.length;
		int res = 0, n = points.length;
		for (int i = 0; i < n; i++) {
			Map<String, Integer> map = new HashMap<>();
			int samep = 1;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
						samep++;
						continue;
					}
					int numerator = points[j][1] - points[i][1];
					int denominator = points[j][0] - points[i][0];
					int gcd = GCD(numerator, denominator);
					String k = numerator / gcd + "_" + denominator / gcd;
					if (map.containsKey(k)) map.put(k, map.get(k) + 1);
					else map.put(k, 2);
					res = Math.max(res, map.get(k) + samep - 1);
				}
			}
			res = Math.max(res, samep);
		}
		return res;
	}

	public int GCD(int a, int b) {
		if (b == 0) return a;
		return GCD(b, a % b);
	}
}
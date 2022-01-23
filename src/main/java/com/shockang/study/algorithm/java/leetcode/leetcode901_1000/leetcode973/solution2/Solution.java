package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode973.solution2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Shockang
 */
public class Solution {
	public int[][] kClosest(int[][] points, int k) {
		Arrays.sort(points, Comparator.comparingInt(p -> (p[0] * p[0] + p[1] * p[1])));
		return Arrays.copyOfRange(points, 0, k);
	}
}
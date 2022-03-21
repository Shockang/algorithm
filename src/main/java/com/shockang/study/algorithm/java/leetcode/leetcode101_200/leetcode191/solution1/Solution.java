package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode191.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int hammingWeight(int n) {
		int weight = 0;
		while (n != 0) {
			n &= n - 1;
			weight++;
		}
		return weight;
	}
}

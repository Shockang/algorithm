package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode201.solution1;

/**
 * n & (n - 1)
 *
 * @author Shockang
 */
public class Solution {
		public int rangeBitwiseAnd(int m, int n) {
				while (m < n) {
						// 抹去最右边的 1
						n = n & (n - 1);
				}
				return n;
		}
}

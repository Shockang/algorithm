package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode441.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int arrangeCoins(int n) {
		return (int) Math.floor(Math.sqrt(2 * (long) n + 0.25) - 0.5);
	}
}

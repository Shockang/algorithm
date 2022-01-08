package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode509.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int fib(int n) {
		if (n < 2) return n;
		int a = 1, b = 1;
		while (--n > 0) a = (b += a) - a;
		return a;
	}
}

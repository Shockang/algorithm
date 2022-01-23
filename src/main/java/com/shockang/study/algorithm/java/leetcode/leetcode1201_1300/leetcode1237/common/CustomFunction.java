package com.shockang.study.algorithm.java.leetcode.leetcode1201_1300.leetcode1237.common;

/**
 * This is the custom function interface.
 * You should not implement it, or speculate about its implementation
 *
 * @author Shockang
 */
public interface CustomFunction {
	// Returns f(x, y) for any given positive integers x and y.
	// Note that f(x, y) is increasing with respect to both x and y.
	// i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
	public int f(int x, int y);
}

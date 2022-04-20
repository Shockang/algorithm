package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode796.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public boolean rotateString(String s, String goal) {
		return s.length() == goal.length() && (s + s).contains(goal);
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1672.solution1;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int maximumWealth(int[][] accounts) {
		return Arrays.stream(accounts).mapToInt(account -> Arrays.stream(account).sum()).max().getAsInt();
	}
}
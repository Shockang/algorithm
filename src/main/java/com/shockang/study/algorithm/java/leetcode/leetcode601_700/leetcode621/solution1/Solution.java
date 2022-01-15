package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode621.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int leastInterval(char[] tasks, int n) {
		int[] arr = new int[26];
		for (char c : tasks) {
			arr[c - 'A']++;
		}
		int max = 0;
		for (int i = 0; i < 26; i++) {
			max = Math.max(max, arr[i]);
		}
		int ret = (max - 1) * (n + 1);
		for (int i = 0; i < 26; i++) {
			if (arr[i] == max) {
				ret++;
			}
		}
		return Math.max(ret, tasks.length);
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode1001_1100.leetcode1024.solution3;

/**
 * @author Shockang
 */
public class Solution {
	public int videoStitching(int[][] clips, int time) {
		int[] maxn = new int[time];
		int last = 0, ret = 0, pre = 0;
		for (int[] clip : clips) {
			if (clip[0] < time) {
				maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
			}
		}
		for (int i = 0; i < time; i++) {
			last = Math.max(last, maxn[i]);
			if (i == last) {
				return -1;
			}
			if (i == pre) {
				ret++;
				pre = last;
			}
		}
		return ret;
	}
}
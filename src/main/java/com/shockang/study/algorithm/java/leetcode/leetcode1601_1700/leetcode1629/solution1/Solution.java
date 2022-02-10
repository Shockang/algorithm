package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1629.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public char slowestKey(int[] releaseTimes, String keysPressed) {
		int n = releaseTimes.length;
		char ans = keysPressed.charAt(0);
		int maxTime = releaseTimes[0];
		for (int i = 1; i < n; i++) {
			char key = keysPressed.charAt(i);
			int time = releaseTimes[i] - releaseTimes[i - 1];
			if (time > maxTime || (time == maxTime && key > ans)) {
				ans = key;
				maxTime = time;
			}
		}
		return ans;
	}
}
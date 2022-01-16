package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode649.solution1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Shockang
 */
public class Solution {
	public String predictPartyVictory(String senate) {
		int n = senate.length();
		Queue<Integer> radiant = new LinkedList<>();
		Queue<Integer> dire = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			if (senate.charAt(i) == 'R') {
				radiant.offer(i);
			} else {
				dire.offer(i);
			}
		}
		while (!radiant.isEmpty() && !dire.isEmpty()) {
			int radiantIndex = radiant.poll(), direIndex = dire.poll();
			if (radiantIndex < direIndex) {
				radiant.offer(radiantIndex + n);
			} else {
				dire.offer(direIndex + n);
			}
		}
		return !radiant.isEmpty() ? "Radiant" : "Dire";
	}
}
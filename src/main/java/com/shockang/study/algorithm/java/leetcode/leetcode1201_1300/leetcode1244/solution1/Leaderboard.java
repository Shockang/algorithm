package com.shockang.study.algorithm.java.leetcode.leetcode1201_1300.leetcode1244.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class Leaderboard {
	Map<Integer, Integer> map;
	int[] scores;

	public Leaderboard() {
		map = new HashMap<>();
		scores = new int[101];
	}

	public void addScore(int playerId, int score) {
		if (map.containsKey(playerId)) {
			score += map.get(playerId);
			reset(playerId);
		}
		map.put(playerId, score);
		if (score >= scores.length) {
			int[] temp = new int[score + 1];
			System.arraycopy(scores, 0, temp, 0, scores.length);
			scores = temp;
		}
		scores[score]++;
	}

	public int top(int K) {
		int sum = 0;
		for (int i = scores.length - 1; i >= 0; i--) {
			if (K == 0) {
				return sum;
			}
			int size = scores[i];
			while (K > 0 && size > 0) {
				sum += i;
				size--;
				K--;
			}
		}
		return sum;
	}

	public void reset(int playerId) {
		if (!map.containsKey(playerId)) {
			return;
		}

		int score = map.get(playerId);
		map.remove(playerId);
		scores[score]--;
	}
}
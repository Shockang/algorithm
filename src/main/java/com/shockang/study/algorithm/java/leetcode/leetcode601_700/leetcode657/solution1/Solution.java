package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode657.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		for (char ch : moves.toCharArray()) {
			if (ch == 'U') y++;
			else if (ch == 'D') y--;
			else if (ch == 'R') x++;
			else if (ch == 'L') x--;
		}
		return x == 0 && y == 0;
	}
}
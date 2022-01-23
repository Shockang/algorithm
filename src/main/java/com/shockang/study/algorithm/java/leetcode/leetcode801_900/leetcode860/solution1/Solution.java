package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode860.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public boolean lemonadeChange(int[] bills) {
		int five = 0, ten = 0;
		for (int bill : bills) {
			if (bill == 5) five++;
			else if (bill == 10) {
				if (five == 0) return false;
				ten++;
				five--;
			} else {
				if (five == 0) return false;
				if (ten == 0) {
					if (five < 3) return false;
					five -= 3;
				} else {
					five--;
					ten--;
				}
			}
		}
		return true;
	}
}
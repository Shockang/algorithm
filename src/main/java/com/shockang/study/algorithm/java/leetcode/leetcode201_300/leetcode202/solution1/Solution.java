package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode202.solution1;

/**
 * 快慢指针
 *
 * @author Shockang
 */
public class Solution {

	public int getNext(int n) {
		int totalSum = 0;
		while (n > 0) {
			int d = n % 10;
			n = n / 10;
			totalSum += d * d;
		}
		return totalSum;
	}

	public boolean isHappy(int n) {
		int slow = n;
		int fast = getNext(n);
		while (fast != 1 && slow != fast) {
			slow = getNext(slow);
			fast = getNext(getNext(fast));
		}
		return fast == 1;
	}
}

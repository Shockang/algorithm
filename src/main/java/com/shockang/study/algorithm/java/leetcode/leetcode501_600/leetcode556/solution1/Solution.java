package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode556.solution1;

/**
 * @author Shockang
 */

public class Solution {
	public int nextGreaterElement(int n) {
		char[] a = ("" + n).toCharArray();
		int len = a.length, i = len - 2;
		while (i >= 0 && a[i + 1] <= a[i]) {
			i--;
		}
		if (i < 0) {
			return -1;
		}
		int j = len - 1;
		while (j >= 0 && a[j] <= a[i]) {
			j--;
		}
		swap(a, i, j);
		reverse(a, i + 1);
		long res = Long.parseLong(new String(a));
		return (int) res == res ? (int) res : -1;
	}

	private void reverse(char[] a, int start) {
		int i = start, j = a.length - 1;
		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}
	}

	private void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

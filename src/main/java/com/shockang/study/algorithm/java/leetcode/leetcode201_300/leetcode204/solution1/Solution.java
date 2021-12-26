package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode204.solution1;

import java.util.Arrays;

/**
 * 埃氏筛
 * Sieve of Eratosthenes(埃拉托斯特尼素数筛选法）
 *
 * @author Shockang
 */
public class Solution {
	public int countPrimes(int n) {
		int[] isPrime = new int[n];
		Arrays.fill(isPrime, 1);
		int ans = 0;
		for (int i = 2; i < n; ++i) {
			if (isPrime[i] == 1) {
				ans += 1;
				if ((long) i * i < n) {
					for (int j = i * i; j < n; j += i) {
						isPrime[j] = 0;
					}
				}
			}
		}
		return ans;
	}
}
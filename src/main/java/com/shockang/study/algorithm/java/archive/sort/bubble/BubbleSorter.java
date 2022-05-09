package com.shockang.study.algorithm.java.archive.sort.bubble;

import com.shockang.study.algorithm.java.archive.sort.Sorter;

/**
 * @author Shockang
 */
public class BubbleSorter implements Sorter {
	@Override
	public void sort(int[] a) {
		if (a == null || a.length < 2) return;
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] > a[j + 1]) swap(a, j, j + 1);
			}
		}
	}
}

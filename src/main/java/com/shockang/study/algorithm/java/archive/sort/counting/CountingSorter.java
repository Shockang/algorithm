package com.shockang.study.algorithm.java.archive.sort.counting;

import com.shockang.study.algorithm.java.archive.sort.Sorter;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class CountingSorter implements Sorter {
	@Override
	public void sort(int[] a) {
		if (a == null || a.length < 2) return;
		countingSort(a, a.length);
	}

	private void countingSort(int[] a, int n) {
		int max = Arrays.stream(a).max().getAsInt();
		int[] c = new int[max];
		for (int tmp : a) {
			c[tmp]++;
		}
		for (int i = 1; i < max; i++) {
			c[i] = c[i] + c[i - 1];
		}
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			int index = c[a[i]] - 1;
			res[index] = a[i];
			c[a[i]]--;
		}
		for (int i = 0; i < n; i++) {
			a[i] = res[i];
		}
	}
}

package com.shockang.study.algorithm.java.archive.sort;

/**
 * @author Shockang
 */
public interface Sorter {
	void sort(int[] a);

	default void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}

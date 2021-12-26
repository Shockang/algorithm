package com.shockang.study.algorithm.scala.archive.sort.merge;

import com.shockang.study.algorithm.scala.archive.sort.Sorter;
import com.shockang.study.algorithm.scala.archive.sort.Sorter;

public class MergeSorter3 implements Sorter {

	private int[] aux;

	@Override
	public void sort(int[] a) {
		if (a == null || a.length < 2) return;
		aux = new int[a.length];
		sort(a, 0, a.length - 1);
	}

	public void sort(int[] nums, int lo, int hi) {
		if (hi <= lo) return;

		int mid = (lo + hi) / 2;
		sort(nums, lo, mid);
		sort(nums, mid + 1, hi);

		merge(nums, lo, mid, hi);
	}

	private void merge(int[] nums, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = nums[k];

		int index = lo;
		while (i <= mid || j <= hi) {
			if (i > mid) nums[index++] = aux[j++];
			else if (j > hi || aux[i] <= aux[j]) nums[index++] = aux[i++];
			else nums[index++] = aux[j++];
		}
	}
}

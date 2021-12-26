package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode215.solution2;

/**
 * 堆排序
 *
 * @author Shockang
 */
public class Solution {
	private int n;

	public int findKthLargest(int[] nums, int k) {
		n = nums.length;
		// 构建大顶堆
		createHeap(nums);
		for (int i = n - 1; i >= 0; i--) {
			// 调整堆结构+交换堆顶元素与末尾元素
			swap(nums, 0, i);
			adjustHeap(nums, 0, i);
		}
		return nums[n - k];
	}

	private void createHeap(int[] nums) {
		// 从第一个非叶子结点从下至上，从右至左调整结构
		for (int i = (n - 1) / 2; i >= 0; i--) {
			adjustHeap(nums, i, n);
		}
	}

	/**
	 * 调整堆
	 *
	 * @param nums   待排序列
	 * @param parent 父节点
	 * @param length 待排序列尾元素索引
	 */
	private void adjustHeap(int[] nums, int parent, int length) {
		// 将tmp作为父节点
		int tmp = nums[parent];
		// 左孩子
		int l = parent * 2 + 1;
		while (l < length) {
			// 右孩子
			int r = l + 1;
			// 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
			if (r < length && nums[l] < nums[r]) l++;
			// 如果父结点的值已经大于孩子结点的值，则直接结束
			if (tmp >= nums[l]) break;
			// 把孩子结点的值赋给父结点
			nums[parent] = nums[l];
			// 选取孩子结点的左孩子结点,继续向下筛选
			parent = l;
			l = parent * 2 + 1;
		}
		nums[parent] = tmp;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
package com.shockang.study.algorithm.java.leetcode.leetcode1101_1200.leetcode1130.solution1;

import java.util.ArrayDeque;

/**
 * 贪心的单调栈
 *
 * @author Shockang
 */
public class Solution {
	public int mctFromLeafValues(int[] A) {
		int res = 0;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(Integer.MAX_VALUE);
		// 最优情况：其实就是严格有序的，从小到大来乘然后累加，对应情况就是类似[4,3,2,1]
		// 指导原则：严格按照arr的顺序下，每次总是用乘积最小两个数一起乘
		for (int a : A) {
			// 不满足有序：一旦发现当前元素大于栈顶，则弹出，（这个元素作为叶子节点，必须要做乘法）
			while (stack.peek() <= a) {
				// 此时需要考虑是新的栈顶 和 当前元素 的最小值 去乘，乘的结果会做累加
				res += stack.pop() * Math.min(stack.peek(), a);
			}
			// 弹出全部比它小的元素后，插入新的元素到栈顶
			stack.push(a);
		}
		// 最后栈里可能存有排序好的数字（本质就是最优的解），需要依次弹出一个并累加乘积
		while (stack.size() > 2) {
			res += stack.pop() * stack.peek();
		}
		return res;
	}
}


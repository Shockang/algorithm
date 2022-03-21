package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode150.solution2;

/**
 * @author Shockang
 */
public class Solution {
	//纯数组模拟栈实现
	public static int evalRPN(String[] tokens) {
		int[] numStack = new int[tokens.length / 2 + 1];
		int index = 0;
		for (String s : tokens) {
			switch (s) {
				case "+":
					numStack[index - 2] += numStack[--index];
					break;
				case "-":
					numStack[index - 2] -= numStack[--index];
					break;
				case "*":
					numStack[index - 2] *= numStack[--index];
					break;
				case "/":
					numStack[index - 2] /= numStack[--index];
					break;
				default:
					// numStack[index++] = Integer.valueOf(s);
					// valueOf 改为 parseInt，减少自动拆箱装箱操作
					numStack[index++] = Integer.parseInt(s);
					break;
			}
		}
		return numStack[0];
	}
}


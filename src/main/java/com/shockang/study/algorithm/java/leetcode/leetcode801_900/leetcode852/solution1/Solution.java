package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode852.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int peakIndexInMountainArray(int[] arr) {
		for(int i = 1; i < arr.length; i++){
			if(arr[i] < arr[i - 1]){
				return i - 1;
			}
		}
		return -1;
	}
}
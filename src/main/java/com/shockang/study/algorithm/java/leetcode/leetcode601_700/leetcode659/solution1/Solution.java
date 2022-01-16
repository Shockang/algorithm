package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode659.solution1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 哈希表+最小堆
 *
 * @author Shockang
 */
public class Solution {
	public boolean isPossible(int[] nums) {
		// 哈希表的键为子序列的最后一个数字，值为最小堆，用于存储所有的子序列长度，
		// 最小堆满足堆顶的元素是最小的，因此堆顶的元素即为最小的子序列长度。
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int x : nums) {
			// 遍历数组，当遍历到元素 x 时，可以得到一个以 x 结尾的子序列。
			if (!map.containsKey(x)) {
				map.put(x, new PriorityQueue<>());
			}
			// 如果哈希表中存在以 x−1 结尾的子序列，则取出以 x−1 结尾的最小的子序列长度，将子序列长度加 1 之后作为以 x 结尾的子序列长度。
			// 此时，以 x−1 结尾的子序列减少了一个，以 x 结尾的子序列增加了一个。
			if (map.containsKey(x - 1)) {
				int prevLength = map.get(x - 1).poll();
				if (map.get(x - 1).isEmpty()) {
					map.remove(x - 1);
				}
				map.get(x).offer(prevLength + 1);
			} else {
				// 如果哈希表中不存在以 x−1 结尾的子序列，则新建一个长度为 1 的以 x 结尾的子序列。
				map.get(x).offer(1);
			}
		}
		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
			PriorityQueue<Integer> queue = entry.getValue();
			if (queue.peek() < 3) {
				return false;
			}
		}
		return true;
	}
}
package com.shockang.study.algorithm.scala.leetcode.leetcode1_100.leetcode1.solution1

import scala.collection.mutable

/**
 * 1. 两数之和
 * <p>
 * 哈希表
 *
 * @author Shockang
 */
object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = mutable.HashMap[Int, Int]()
    for (i <- nums.indices)
      if (map.contains(nums(i)))
        return Array(map(nums(i)), i)
      else
        map(target - nums(i)) = i
    Array(-1, -1)
  }
}

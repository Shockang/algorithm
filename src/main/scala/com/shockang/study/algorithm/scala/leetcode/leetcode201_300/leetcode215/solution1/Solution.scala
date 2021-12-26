package com.shockang.study.algorithm.scala.leetcode.leetcode201_300.leetcode215.solution1

import scala.collection.mutable

/**
 *
 * @author Shockang
 */
object Solution {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    val priorityQueue = mutable.PriorityQueue[Int]()
    nums.foreach(priorityQueue.enqueue(_))
    for (_ <- 0 until k - 1) priorityQueue.dequeue()
    priorityQueue.dequeue()
  }
}
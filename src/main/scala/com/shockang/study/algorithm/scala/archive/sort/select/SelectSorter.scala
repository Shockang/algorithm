package com.shockang.study.algorithm.scala.archive.sort.select

import com.shockang.study.algorithm.scala.archive.sort.Sorter

/**
 * 选择排序
 *
 * @author Shockang
 */
class SelectSorter extends Sorter {
  override def sort(a: Array[Int]): Unit = {
    if (a == null || a.length < 2) return
    val n = a.length
    // i 从左到右遍历每个数组元素
    for (i <- 0 until n) {
      var min = a(i)
      var index = i
      // j 从左到右选择最小的值
      for (j <- i + 1 until n) {
        if (a(j) < min) {
          min = a(j)
          index = j
        }
      }
      swap(a, i, index)
    }
  }
}

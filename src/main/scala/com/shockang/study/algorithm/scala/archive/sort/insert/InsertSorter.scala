package com.shockang.study.algorithm.scala.archive.sort.insert

import com.shockang.study.algorithm.scala.archive.sort.Sorter

/**
 * 插入排序
 *
 * @author Shockang
 */
class InsertSorter extends Sorter {
  override def sort(a: Array[Int]): Unit = {
    if (a == null || a.length < 2) return
    val n = a.length
    // i 从左到右遍历每个数组元素，跳过首个元素
    for (i <- 1 until n) {
      val num = a(i)
      var j = i
      // j 从右到左进行插入操作
      while (j > 0 && a(j - 1) > num) {
        // 往右挪，给插入腾出位置
        a(j) = a(j - 1)
        j -= 1
      }
      // 插入
      a(j) = num
    }
  }
}

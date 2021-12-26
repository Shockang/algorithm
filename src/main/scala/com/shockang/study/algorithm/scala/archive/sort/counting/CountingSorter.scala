package com.shockang.study.algorithm.scala.archive.sort.counting

import com.shockang.study.algorithm.scala.archive.sort.Sorter

class CountingSorter extends Sorter {
  override def sort(a: Array[Int]): Unit = {
    if (a == null || a.length < 2) return
    countingSort(a, a.length)
  }


  // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
  def countingSort(a: Array[Int], n: Int): Unit = {
    // 查找数组中数据的范围
    var max = a(0)
    for (i <- 1 until n) {
      if (max < a(i)) max = a(i)
    }
    val c = new Array[Int](max + 1) // 申请一个计数数组c，下标大小[0,max]
    for (i <- 0 to max) {
      c(i) = 0
    }
    // 计算每个元素的个数，放入c中
    for (i <- 0 until n) {
      c(a(i)) += 1
    }
    // 依次累加
    for (i <- 1 to max) {
      c(i) = c(i - 1) + c(i)
    }
    // 临时数组r，存储排序之后的结果
    val r = new Array[Int](n)
    // 计算排序的关键步骤，有点难理解
    for (i <- n - 1 to 0 by -1) {
      val index = c(a(i)) - 1
      r(index) = a(i)
      c(a(i)) -= 1
    }
    // 将结果拷贝给a数组
    for (i <- 0 until n) {
      a(i) = r(i)
    }
  }
}

package com.shockang.study.algorithm.scala.archive.sort.merge

import com.shockang.study.algorithm.scala.archive.sort.Sorter

class MergeSorter2 extends Sorter {
  var aux: Array[Int] = _

  override def sort(a: Array[Int]): Unit = {
    if (a == null || a.length < 2) return
    aux = new Array[Int](a.length)
    mergeSort(a, 0, a.length - 1)
  }

  def mergeSort(nums: Array[Int], lo: Int, hi: Int): Unit = {
    if (lo < hi) {
      val mid = (lo + hi) / 2
      mergeSort(nums, lo, mid)
      mergeSort(nums, mid + 1, hi)
      merge(nums, lo, mid, hi)
    }
  }

  private def merge(nums: Array[Int], lo: Int, mid: Int, hi: Int): Unit = {
    var i = lo
    var j = mid + 1
    for (k <- lo to hi) aux(k) = nums(k)
    var index = lo
    while (i <= mid || j <= hi) {
      if (i > mid) {
        nums(index) = aux(j)
        index += 1
        j += 1
      } else if (j > hi || aux(i) <= aux(j)) {
        nums(index) = aux(i)
        index += 1
        i += 1
      } else {
        nums(index) = aux(j)
        index += 1
        j += 1
      }
    }
  }
}

package com.shockang.study.algorithm.scala.archive.binarysearch.variant.first_e

import com.shockang.study.algorithm.scala.archive.binarysearch.BinarySearch

class FirstEBSearch extends BinarySearch {
  override def search(a: Array[Int], value: Int): Int = {
    if (a == null || a.length == 0) return -1
    val n = a.length
    var low = 0
    var high = n - 1
    while (low <= high) {
      val mid = low + ((high - low) >> 1)
      if (a(mid) >= value) high = mid - 1
      else low = mid + 1
    }
    if (low < n && a(low) == value) low
    else -1
  }
}

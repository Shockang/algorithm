package com.shockang.study.algorithm.scala.archive.binarysearch.variant.first_e

import com.shockang.study.algorithm.scala.archive.binarysearch.BinarySearch

class FirstEBSearch2 extends BinarySearch {
  override def search(a: Array[Int], value: Int): Int = {
    if (a == null || a.length == 0) return -1
    val n = a.length
    var low = 0
    var high = n - 1
    while (low <= high) {
      val mid = low + ((high - low) >> 1)
      if (a(mid) > value) high = mid - 1
      else if (a(mid) < value) low = mid + 1
      else if ((mid == 0) || (a(mid - 1) != value)) return mid
      else high = mid - 1
    }
    -1
  }
}

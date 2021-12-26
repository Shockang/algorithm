package com.shockang.study.algorithm.scala.archive.sort

trait Sorter {
  def sort(a: Array[Int])

  protected def swap(a: Array[Int], i: Int, j: Int): Unit = {
    val tmp = a(i)
    a(i) = a(j)
    a(j) = tmp
  }
}

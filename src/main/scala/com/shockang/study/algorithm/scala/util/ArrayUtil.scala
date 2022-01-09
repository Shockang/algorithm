package com.shockang.study.algorithm.scala.util

import java.util.StringJoiner
import scala.language.implicitConversions

/**
 *
 * @author Shockang
 */
object ArrayUtil {
  implicit def stringToIntArray(str: String): Array[Int] = {
    var s = str.trim()
    // [2,7,11,15]
    s = s.substring(1, s.length - 1)
    val splits = s.split(",")
    val n = splits.length
    val res = new Array[Int](n)
    for (i <- 0 until n) {
      res(i) = splits(i).toInt
    }
    res
  }

  implicit def intArrayToString(a: Array[Int]): String = {
    val sj = new StringJoiner(",", "[", "]")
    for (i <- a) {
      sj.add(String.valueOf(i))
    }
    sj.toString
  }

  def print[T](a: Array[T]): Unit = {
    // scalastyle:off println
    println(a.mkString(","))
    // scalastyle:on println
  }
}

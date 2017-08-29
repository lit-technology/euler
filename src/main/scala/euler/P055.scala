package main.scala.euler

import main.scala.utils.{Palindrome, Permutation}

object P055 {

  def lychrelNumbers(limit: Int = 10000): Int = {
    var count = 0
    for (i <- 12 to limit) {
      if (Permutation.isLychrel(i)) {
        count += 1
      }
    }
    count
  }
}

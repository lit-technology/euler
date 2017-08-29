package main.scala.euler

import main.scala.utils.{Concat, Permutation}

object P032 {

  /**
    * Euler Problem 32.
    * @return
    */
  def pandigitalProducts(): Long = {
    var sum = Set[Long]()
    var product = 0
    var compiled: Long = 0
    for (i <- 2 to 99) {
      // 1 digit * 4digit, 2 digit * 3 digit 
      var jStart = if (i > 9) 123 else 1234
      // Reduces problem set as no point doing 99 * 10000 etc when answer is too high
      var jEnd = 10000 / i - 1
      for (j <- jStart to jEnd) {
        product = i * j
        compiled = Concat.concat(i, j, product)
        if (Permutation.isPandigital(compiled)) {
          sum += product
        }
      }
    }
    sum.sum
  }
}

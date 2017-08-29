package main.scala.euler

import main.scala.utils.{Concat, Permutation}

object P038 {

  /**
    * Euler Problem 38. 
    * N starts with 9, to get a number starting with 9.
    * N cannot be 2 digits otherwise n* 1..3 = 8 digit number, and n * 1...4 = 11 digit number.
    * E.g 90,180,270,360
    * N cannot be 3 digits otherwise n* 1..2 = 7 digit number, and N * 1..3 = 11 digit number
    * E.g 900,1800,2700
    * N must be 4 digits then.
    * N 2nd digit cannot be > 4 otherwise will result in two 9s.
    * E.g 95, 190 vs 94, 188
    * N no digits can be 1 or 8 otherwise will result in two 1s or 8s respectively. 
    * E.g 9123, 18246. 9128, 18???
    * @return Largest pandigital
    */
  def pandigitalMultiples(): Long = {
    var n: Long = 0
    for (i <- 9765 to 9234 by -1) {
      n = Concat.concat(i, i * 2)
      if (Permutation.isPandigital(n)) {
        return n
      }
    }
    0
  }
}

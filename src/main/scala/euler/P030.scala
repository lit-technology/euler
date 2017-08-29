package main.scala.euler

object P030 {

  /**
    * Euler Problem 30. Upper bound is 9 pow 5 = 59049
    * 59049 has 5 digits, safely make it 6 so 6 * 9 pow 5 = 354292.
    *
    * @return
    */
  def digitFifthPowers(): Long = {
    var sum, sumOfPowers, n, d: Long = 0
    for (i <- 2 to 355000) {
      n = i
      sumOfPowers = 0
      while (n > 0) {
        d = n % 10 // Get digit
        n /= 10 // Remove digit
        sumOfPowers += Math.pow(d, 5).toLong
      }
      if (sumOfPowers == i) {
        sum += sumOfPowers
      }
    }
    sum
  }
}

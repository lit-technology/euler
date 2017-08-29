package main.scala.euler

import scala.collection.mutable.ListBuffer

object P021 {

  /**
    * Euler Problem 21.
    * @param max
    * @return
    */
  def amicableNumbers(max:Int = 1000):Long = {
    // TODO:
    var b, sumFactorsA: Long = 0
    var primes = ListBuffer[Long]()
    var sum: Long = 0
    for (a <- 2L to max) {
      if (EulerUtil.isPrime(a.toInt)) {
        primes += a
      }
      sumFactorsA = sumOfFactors(a.toInt, primes.toList)
      if (sumFactorsA > a && sumFactorsA < max &&
        sumOfFactors(sumFactorsA, primes.toList) == a) {
        sum += a + sumFactorsA
      }
    }
    sum
  }
}

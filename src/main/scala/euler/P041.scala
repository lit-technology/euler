package main.scala.euler

import main.scala.utils.Primes

object P041 {

  /**
    * Euler Problem 41
    * @return
    */
  def pandigitalPrime():Long = {
    var pandigitals = "123456789"
    val primesSet = Primes.primesArrayLong(987654321).toSet
    while (!pandigitals.isEmpty) {
      for (pandigital <- pandigitals.permutations) {
        var n = pandigital.toLong
        var max: Long = 0
        if (primesSet.contains(n) && n > max) {
          max = n
        }
        max
      }
      pandigitals = pandigitals.substring(0, pandigitals.length - 1)
    }
    0
  }
}

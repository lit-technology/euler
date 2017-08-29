package main.scala.euler

import main.scala.utils.Primes

object P035 {

  /**
    * Euler Problem 35. Unfinished
    * @param max
    * @return
    */
  def circularPrimes(max: Int = 100): Int = {
    var count = 0
    var primes = Primes.primesArray(max).toSet
    var prime: String = ""
    var exists = false
    var value: Int = 0
    var sum: Int = 0
    var iter = primes.iterator
    while (iter.hasNext) {
      prime = iter.next().toString
      exists = true
      sum = 0
      for (permutation <- prime.permutations) {
        if (permutation.length == prime.length) {
          sum += 1
          value = permutation.toInt
          if (!primes.contains(value)) {
            exists = false
          } else {
            primes -= value
          }
        }
      }
      if (exists) {
        count += sum
      }
    }
    count
  }
}

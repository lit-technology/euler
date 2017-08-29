package main.scala.euler

import main.scala.utils.{Concat, Primes}

object P037 {

  /**
    * Euler Problem 37. Brute forces
    * @return
    */
  def truncatablePrimes(): Int = {
    var sum = 0
    val primeDigits = Set(1, 2, 3, 5, 7, 9)
    var primeSet = Primes.primesArray().toSet
    var count = 0
    var trunctablePrimes = Set(2, 3, 5, 7)
    while (count < 11) {
      var newPrimes: Set[Int] = Set()
      for (trunctablePrime <- trunctablePrimes) {
        for (prime <- primeDigits) {
          var n = Concat.concat(trunctablePrime, prime)
          if (primeSet.contains(n)) {
            newPrimes += n
            if (Primes.isTruncatablePrime(n)) {
              count += 1
              sum += n
            }
          }
        }
      }
      trunctablePrimes = newPrimes
    }
    sum
  }
}

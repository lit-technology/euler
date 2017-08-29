package main.scala.euler

import main.scala.utils.{Concat, Permutation}

object P049 {

  def primePermutations(digits: Int = 4, diff: Int = 3330, iters: Int = 3): Long = {
    val primes = PrimeSieve.primes(Math.pow(10, digits).toInt)
    var i = 0
    val lower = Math.pow(10, digits - 1).toLong
    while (primes(i) < lower) {
      i += 1
    }
    var primesSet = Set[Int]()
    primesSet += primes(i)
    val higher = lower * 10
    while (primes(i) < higher) {
      primesSet += primes(i)
      i += 1
    }
    i -= 1
    var prime = primes(i)
    while (prime > lower) {
      prime = primes(i)
      var nextPrime = prime - diff
      var itersLeft = iters - 1
      var permutation = true
      while (itersLeft > 0) {
        if (permutation && nextPrime > lower) {
          permutation = Permutation.isPermutation(nextPrime, nextPrime + 3330)
        }
        nextPrime -= diff
        itersLeft -= 1
      }
      if (permutation) {
        return Concat.concatBig(Concat.concatBig(prime - diff * 2, prime - diff).toLong, prime).toLong
      }
      i -= 1
    }
    0
  }
}

package main.scala.euler

import main.scala.utils.Primes

object P058 {

  def spiralPrimes(percent: Int = 10): Int = {
    var sideLength = 1
    var primes = Primes.primesArray(10000000)
    var max = primes.last
    var primesSet = primes.toSet
    var corner: Int = 0
    var i: BigInt = 1
    var primesCount = 0
    var totalDiagonals = 1

    while (true) {
      i += (sideLength * 2)
      if (i < max && primesSet.contains(i.toInt)) {
        primesCount += 1
      } else if (i >= max && i.isProbablePrime(10)){
        primesCount += 1
      }
      totalDiagonals += 1
      corner+=1
      if (corner == 1 || corner == 4) {
        if ((primesCount * 100) / totalDiagonals < percent) {
          if (corner == 1) { // Top right corner. or EvenxEven.
            return sideLength * 2
          } else { // Bottom right corner. or OddxOdd
            return sideLength * 2 + 1
          }
        }
      }
      if (corner == 4) {
        sideLength += 1
        corner = 0
      }
    }
    sideLength
  }
}

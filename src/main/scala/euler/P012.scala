package main.scala.euler

object P012 {

  /**
    * Euler Problem 12.
    * @param min Minimum limit of divisors
    * @return Sum of Triangular Numbers until finding minimum limit of divisors
    */
  def highlyDivisibleTriangularNumber(min: Int): Int = {
    var sum = 1
    var count = 2
    var primes = ListBuffer[Int]()
    while (EulerUtil.divisors(sum, primes.toList) < min) {
      if (EulerUtil.isPrime(count)) {
        primes += count
      }
      sum += count
      count+= 1
    }
    sum
  }
}

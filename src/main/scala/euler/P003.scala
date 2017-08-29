package main.scala.euler

object P003 {

  /**
    * Euler Problem 3
    * @param n Positive number
    * @return Largest prime factor of N
    */
  def largestPrimeFactor(n:Long):Long = {
    var largestPrime: Long = 0
    var a: Long = 3 // Primes start from 3
    var num = n
    // Problem set is divided until largest prime is left or number that isn't divisible (prime)
    // See Prime Factorization for why this loop will end
    while (a < num / a) {
      if (num % a == 0) {
        largestPrime = a
        num = num / a // Divide the problem set
      } else { // Primes can only be odd numbers
        a += 2
      }
    }
    if (largestPrime < num) {
      largestPrime = num
    }
    largestPrime
  }
  
}

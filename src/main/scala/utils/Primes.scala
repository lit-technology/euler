package main.scala.utils

import java.util

import scala.collection.mutable.ArrayBuffer

object Primes {

  /**
    * Calculates possible divisions from 2 -> Sqrt(n). Only checks odd numbers.
    * @param n Positive number
    * @return
    */
  def isPrime(n:Int):Boolean = {
    if (n == 1) {
      return false
    } else if (n == 2) {
      return true
    } else if (n % 2 == 0) {
      return false
    }
    var i = 3
    val sqrt = math.sqrt(n)
    while(i <= sqrt) {
      if (n % i == 0) {
        return false
      }
      i += 2
    }
    true
  }

  def isPrime(n:Long):Boolean = {
    if (n == 1) {
      return false
    } else if (n == 2) {
      return true
    } else if (n % 2 == 0) {
      return false
    }
    var i = 3
    val sqrt = math.sqrt(n)
    while(i <= sqrt) {
      if (n % i == 0) {
        return false
      }
      i += 2
    }
    true
  }

  def isTruncatablePrime(num:Int):Boolean = {
    if (isPrime(num)) {
      var n = num
      while (n > 10) {
        n /= 10
        if (!isPrime(n)) {
          return false
        }
      }
      var divisor = 10
      while (divisor < num) {
        if (!isPrime(num % divisor)) {
          return false
        }
        divisor *= 10
      }
      return true
    }
    false
  }
  
  def primesArray(n: Int = Integer.MAX_VALUE): Array[Int] = {
    var primes = new ArrayBuffer[Int]()
    primes += 2
    primes += 3
    val bits = new util.BitSet()
    for (prime <- primes) {
      for (i <- prime * prime to n by + prime) {
        bits.set(i, true)
      }
    }
    var prime = 3
    while (prime < n) {
      prime += 2
      while (bits.get(prime)) {
        prime += 2
      }
      var primeSq = prime * prime // Integer overflow
      if (primeSq > 0) {
        for (i <- primeSq to n by +prime) {
          bits.set(i, true)
        }
      }
      primes += prime
    }
    primes.toArray
  }

  def primesArrayLong(n: Long = Long.MaxValue): Array[Long] = {
    var primes = new ArrayBuffer[Long]()
    primes += 2
    primes += 3
    val bits = new util.BitSet()
    for (prime <- primes) {
      for (i <- prime * prime to n by + prime) {
        bits.set(i.toInt, true)
      }
    }
    var prime = 3
    while (prime < n) {
      prime += 2
      while (bits.get(prime)) {
        prime += 2
      }
      var primeSq = prime * prime // Integer overflow
      if (primeSq > 0) {
        for (i <- primeSq to n by +prime) {
          bits.set(i.toInt, true)
        }
      }
      primes += prime
    }
    primes.toArray
  }
  
  def numberOfPrimeFactors(n: Int, primes: Array[Int]):Int = {
    var count: Int = 0
    var remainder = n
    for (prime <- primes) {
      // If prime * prime > N. There are no more prime factors that cannot be found assuming primes is sorted.
      // Since there are remainders, return +1 since all numbers are divisible by set of primes.
      if (prime * prime > n) {
        count += 1
        return count
      }
      if (remainder % prime == 0) { // Found a prime factor.
        count += 1 
        while (remainder % prime == 0) { // Prime Factorize n to reduce problem set / possible prime factors.
          remainder /= prime
        }
      }
      // Found the last prime factor, divided into 1. Return count of prime factors.
      if (remainder == 1) {
        return count
      }
    }
    count
  }

  def primesSumArray(primes: Array[Int], max: Int = 1000000): Array[Int] = {
    var primesSum = new ArrayBuffer[Int]()
    primesSum += 0
    var currentSum = 0
    var i = -1
    while (currentSum < max) {
      i += 1
      currentSum += primes(i)
      primesSum += currentSum
    }
    primesSum.toArray
  }
  
}

package main.scala.utils

object Factor {

  /**
    * Calculates LCM by multiplying (A,B) and dividing by its GCD. E.g 24*36 =  864 / 12 = 72  
    * @param a Positive
    * @param b Positive
    * @return LCM between A, B
    */
  def lcm(a:Int, b:Int):Int = {
    a * b / gcd(a, b)
  }

  /**
    * Calculates GCD (Greatest Common Divisor) using Euclidean's Algorithm
    * @param a Positive 
    * @param b Positive
    * @return GCD between A, B
    */
  def gcd(a:Int, b:Int):Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  /**
    *
    * @param n Number to count how many divisors
    * @param primes List of primes below N (handles overflow)
    * @return Divisors of N
    */
  def divisors(n: Int, primes: List[Int]): Int = {
    var divisors = 1 // Including 1
    var exponent: Int = 0
    var num: Long = n
    val sqrt = Math.sqrt(num)
    for (prime <- primes) {
      if (prime > sqrt) { // If there is remainder/no longer divisible, multiply 2 to permutation choices
        return divisors * 2
      }
      exponent = 1 // Maximum exponent of prime number
      while (num % prime == 0) {
        exponent+= 1
        num = num / prime
      }
      // Permutation / choose from prime (exponent) + 1(original) times
      // E.g 2, 4, 8 etc. are all divisors.
      divisors *= exponent
      if (num == 1) { // No more divisors to find
        return divisors
      }
    }
    divisors
  }

  def sumOfFactors(num:Long, primes:List[Long]): Long = {
    var n = num
    var square:Long = 0
    var sum:Long = 1
    var i = 0
    var p: Long = primes.head
    while (p * p <= n && n > 1 && i < primes.length) {
      p = primes(i)
      if (n % p == 0) {
        square = p * p
        n = n / p
        while (n % p == 0) {
          square = square * p
          n = n / p
        }
        sum = sum * (square - 1) / (p - 1)
      }

      i+= 1
    }
    if (n > 1) {
      sum *= (n + 1)
    }
    sum
  }
}

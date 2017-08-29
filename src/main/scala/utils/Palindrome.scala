package main.scala.utils

object Palindrome {

  def createPalindrome(num: Int, base: Int, isOdd: Boolean): Int = {
    var n = num
    var palin = num
    if (isOdd) {
      n /= base
    }
    while (n > 0) {
      palin = palin * base + (n % base)
      n /= base
    }
    palin
  }
  
  def isPalindrome(n: Int, base: Int): Boolean = {
    var reverse = 0
    var i = n
    while (i > 0) {
      reverse = base * reverse + i % base
      i /= base
    }
    reverse == n
  }
  
  def isPalindrome(n: BigInt): Boolean = {
    n.toString().equals(reverseNumberString(n))
  }

  def isPalindrome(n: BigInt, n2: BigInt): Boolean = {
    n == n2
  }

  def reverseNumberString(n: BigInt): String = {
    n.toString().reverse
  }

  def reverseNumber(n: BigInt): BigInt = {
    BigInt.apply(reverseNumberString(n))
  }
  
  
}

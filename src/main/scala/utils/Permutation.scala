package main.scala.utils

object Permutation {

  def isPermutation(n: Int, n2: Int): Boolean = {
    var digitArray = new Array[Int](10)
    storeDigits(digitArray, n)
    storeDigits(digitArray, n2, incr = false)
    for (digit <- digitArray) {
      if (digit != 0) {
        return false
      }
    }
    true
  }

  def storeDigits(digitArray: Array[Int], n: Int, incr: Boolean = true): Unit = {
    var tmp = n
    while (tmp > 0) {
      if (incr) {
        digitArray(tmp % 10) += 1
      } else {
        digitArray(tmp % 10) -= 1
      }
      tmp /= 10
    }
  }



  def isLychrel(i: Int, count: Int = 50): Boolean = {
    var n: BigInt = i
    n += Palindrome.reverseNumber(n)

    for (j <- 0 to count) {
      var n2 = Palindrome.reverseNumber(n)
      if (Palindrome.isPalindrome(n, n2)) {
        return false
      }
      n += n2
    }
    true
  }

  def isPandigital(num: Long): Boolean = {
    if (num < 123456789 || num > 123456789) {
      return false
    }
    var n = num
    var digits, count, tmp = 0

    while (n > 0) {
      tmp = digits
      digits = digits | 1 << ((n % 10) - 1).toInt
      if (tmp == digits) {
        return false
      }
      count+= 1
      n /= 10
    }
    digits == (1 << count) - 1
  }

  def prefix(num: Int): Int = {
    var n = num
    while (n > 10) {
      n /= 10
    }
    n
  }

  def suffix(n: Int): Int = {
    n % 10
  }
}

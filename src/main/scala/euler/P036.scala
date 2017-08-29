package main.scala.euler

import main.scala.utils.Palindrome

object P036 {

  /**
    * Euler Problem 36. Generates Palindromes by reversing the number and prefixing it. 
    * Odd numbers automatically slash a number in the middle 
    * E.g Palindrome even 21 = 1221, odd 21 = 121.
    * @param max Max palindrome number 
    * @return Sum of numbers that are palindrome in Base 10 (Normal) and 2 (Binary)
    */
  def doubleBasePalindromes(max: Int = 1000000): Int = {
    var sum = 0
    var n = 0
    var isOdd = false
    for (i <- 0 to 1) {
      isOdd = i % 2 == 0
      var j = 1
      n = Palindrome.createPalindrome(j, 10, isOdd)
      while (n < max) {
        if (Palindrome.isPalindrome(n, 2)) {
          sum += n
        }
        j+= 1
        n = Palindrome.createPalindrome(j, 10, isOdd)
      }
    }
    sum
  }
}

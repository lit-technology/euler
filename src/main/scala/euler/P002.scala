package main.scala.euler

object P002 {

  /**
    * Euler Problem 2
    * @param limit Top limit of Fibonacci numbers
    * @return Sum of all even Fibonacci numbers from 1 -> Limit
    */
  def evenFibonacciNumbers(limit:Int):Int = {
    var sum = 0
    var fibonacci1 = 1
    var fibonacci2 = 2
    while (fibonacci1 + fibonacci2 < limit) {
      if (fibonacci2 % 2 == 0) {
        sum += fibonacci2
      }
      var temp = fibonacci2
      fibonacci2 = fibonacci2 + fibonacci1
      fibonacci1 = temp
    }
    if (fibonacci2 % 2 == 0) {
      sum += fibonacci2
    }
    sum
  }
}

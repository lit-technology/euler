package main.scala.utils

object Factorials {

  def factorialsMap(n: Int): Map[Int, BigInt] = {
    var factorials:Map[Int, BigInt] = Map()
    var factorial: BigInt = 1
    for (i <- 1 to n) {
      factorial *= i
      factorials += (i -> factorial)
    }
    factorials
  }

  def factorial(n: BigInt):BigInt = {
    if (n == 0) {
      1
    } else {
      var sum: BigInt = 1
      for (i <- 1 to n.toInt) {
        sum *= i
      }
      sum
    }
  }
}

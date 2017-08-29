package main.scala.euler

object P056 {
  
  def powerfulDigitSum(limit: Int = 100): Int = {
    var max = 0
    var n: BigInt = 0
    for (a <- 1 to limit) {
      n = a
      for (b <- 2 to limit) {
        n *= a
        var digitSum = sum(n)
        if (digitSum > max) {
          max = digitSum
        }
      }
    }
    max
  }


  def sum(n: BigInt): Int = {
    var sum = 0
    for (c <- n.toString().toCharArray) {
      sum += c.toInt - 48
    }
    sum
  }
}

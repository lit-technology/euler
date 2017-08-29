package main.scala.utils

object Concat {

  def concatBig(n: Int, n2: Int): Double = {
    n * math.pow(10, Math.floor(Math.log10(n2) + 1)) + n2
  }

  def concatBig(n: Double, n2: Double): Double = {
    n * math.pow(10, Math.floor(Math.log10(n2) + 1)) + n2
  }

  def concat(n: Int*): Int = { //TODO: Fix.
    var num = 0
    for (i <- 0 until n.length - 1) {
      num += n(i) * math.pow(10, n.length - 1 - i).toInt
    }
    num += n.last
    num
  }
}

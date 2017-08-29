package main.scala.euler

import main.scala.utils.Factor

object P039 {

  /**
    * Euler Problem 39.
    * Euclid states for every Pythagorean Triplet where m > n > 0
    * a =m2-n2
    * b =2m*n
    * c =m2+n2
    * Meaning (a)2+(b)2=(c)2 or (m2-n2)2+(2m*n)2=(m2+n2)2 
    * @param max
    * @return
    */
  def integerRightTriangles(max:Int = 1000):Int = {
    var maxSolutions = 0
    var num = 0
    for (c <- 1 to max) {
      var sqrt = math.sqrt(c / 2).toInt
      var solutions = 0
      for (m <- 2 to sqrt) {
        if ((c / 2) % m == 0) { // M found
        var n = 0
          if (m % 2 == 0) {
            n = m + 1
          } else {
            n = m + 2
          }
          while (n < 2 * m && n <= c / (2 * m)) {
            // If n & m coprime, means a pythagorean triplet found
            if (c / (2 * m) % n == 0 && Factor.gcd(n, m) == 1) {
              solutions += 1
            }
            n+= 2
          }
        }
      }
      if (solutions > maxSolutions) {
        maxSolutions = solutions
        num = c
      }
    }
    num
  }
}

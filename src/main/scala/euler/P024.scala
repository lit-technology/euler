package main.scala.euler

object P024 {

  /**
    * Euler Problem 24. Uses Factorial Number System, which helps order permutations in 
    * @param count N-th permutation in lexicographical order
    * @param digits
    */
  def lexicographicPermutations(count:Long = 1000000, digits:List[Long]= List[Long](9, 8, 7, 6, 5, 4, 3, 2, 1)) {
    var n:Long = count - 1
    val factoid = Array.fill(digits.length){0L}
    var fac = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
    for (i <- digits.length -1 until 0 by -1) {
      factoid(i) = n / fac
      n %= fac
      fac /= i + 1
    }
    for (i <- digits.indices) {
      for (j <- i -1 to 0 by -1) {
        if (factoid(j) >= factoid(i)) {
          factoid(j) += 1
        }
      }
    }

    for (i <- digits.length-1 to 0 by -1) {
      print(factoid(i))
    }
  }
}

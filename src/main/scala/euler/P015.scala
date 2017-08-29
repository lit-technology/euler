package main.scala.euler

object P015 {

  /**
    * Euler Problem 15. Consider you must go right x times and down y times always to reach the bottom right, it is a permutation case.
    * Permutation algorithm states with repeated elements, possible cases = (elementsSize)! / repeated1Size! * repeated2Size! etc.
    * @param x Represents Right
    * @param y Represents Down
    * @return
    */
  def latticePaths(x:BigInt, y:BigInt):BigInt = {
    EulerUtil.factorial(x + y) / (EulerUtil.factorial(x) * EulerUtil.factorial(y))
  }
}

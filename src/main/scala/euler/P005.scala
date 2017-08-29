package main.scala.euler

import main.scala.utils.Factor

object P005 {

  /**
    * Euler Problem 5. Smallest multiple is calculated by using LCM between all numbers in array lcm(lcm(1,2), 3).
    * @param array Array of positive numbers
    * @return Number that is dividable by all numbers in Array
    */
  def smallestMultiple(array: Array[Int]):Long = {
    var multiple = Factor.lcm(array(0), array(1))
    for(i <- 2 until array.length) {
      multiple = Factor.lcm(multiple, array(i))
    }
    multiple
  }
}

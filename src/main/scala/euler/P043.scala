package main.scala.euler

object P043 {

  /**
    * Euler Problem 43. Permutates through pandigitals and checks up conditions accordingly
    * @return
    */
  def substringDivisibility(): Long = {
    var sum: Long = 0
    var pandigitals = "1234567890"
    for (pandigital <- pandigitals.permutations) {
      if (!pandigital.startsWith("0")) {
        // Rule 1. No need to minus 48 as modulo
        if (pandigital.charAt(3).toInt % 2 != 0) {
          //println(pandigital + "Rule 1")
        } else if (Integer.parseInt(pandigital.substring(2, 5)) % 3 != 0) {
          //println(pandigital + "Rule 2")
        } else if ((pandigital.charAt(5) - 48) % 5 != 0) {
          //println(pandigital + "Rule 3")
        } else if (Integer.parseInt(pandigital.substring(4, 7)) % 7 != 0) {
          //println(pandigital + "Rule 4")
        } else if (Integer.parseInt(pandigital.substring(5, 8)) % 11 != 0) {
          //println(pandigital + "Rule 5")
        } else if (Integer.parseInt(pandigital.substring(6, 9)) % 13 != 0) {
          //println(pandigital + "Rule 6")
        } else if (Integer.parseInt(pandigital.substring(7, 10)) % 17 != 0) {
          //println(pandigital + "Rule 7")
        } else {
          sum += pandigital.toLong
        }
      }
    }
    sum
  }
}

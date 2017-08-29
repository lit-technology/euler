package main.scala.euler

object P008 {

  /**
    * Euler Problem 8.
    * @param count
    * @param str
    * @return 
    */
  def largestProductInASeries(count:Int, str:String): Long = {
    //TODO:
    val s = str.replaceAll("\n", "")
    var max: Long = 0
    var ints = s.map(_.toInt - 48)
    for (i <- count to s.length) {
      var product: Long = ints.slice(i - count, i).product
      if (product > max) {
        max = product
      }
      if (product == 2091059712) {
        println(ints.slice(i - count, i))
      }
    }
    max
  }
}

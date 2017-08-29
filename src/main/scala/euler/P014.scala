package main.scala.euler

object P014 {

  /**
    * Euler Problem 14. Chains each individual number and caches them, in subsequent chain count checks in cache for each chain event
    * @param limit Top limit to find longest Collatz Sequence
    * @return Index of longest Collatz Sequence
    */
  def longestCollatzSequence(limit:Long = 1000000):Long = {
    var index:Long = 0
    var max:Long = 0
    var cache = Map[Long, Long]()
    for(i <- 2L to limit) {
      val count = chain(i, cache)
      if (count > max) {
        index = i
        max = count
      }
      cache += (i -> count)
    }
    index
  }

  def chain(num:Long, cache: Map[Long, Long]):Long = {
    var count: Long = 0
    var n = num
    while(n != 1) {
      if (cache.contains(n)) {
        return count + cache(n)
      }
      if (n % 2 == 0) {
        n = n / 2
      } else {
        n = n * 3 + 1
      }
      count += 1
    }
    count
  }
}

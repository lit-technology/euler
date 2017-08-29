package main.scala

class PrefixTree[A] {
  var branches: Map[Int, Branch[A]] = Map()

  def get(key: A): Branch[A] = {
    branches(key.hashCode())
  }

  def +=(key: A): Unit = {
    branches += (key.hashCode() -> new Branch)
  }

  def -=(key: A): Unit = {
    branches -= key.hashCode()
  }

  def contains(key: A): Boolean = {
    branches.contains(key.hashCode())
  }

  def contains(keys: Seq[A]): Boolean = {
    var branch = get(keys.head)
    if (branch != null) {
      return branch.contains(keys.slice(1, keys.length))
    }
    false
  }
}

class Branch[A] extends PrefixTree[A] {

}

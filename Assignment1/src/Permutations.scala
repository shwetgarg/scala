/**
 * Created by shweta on 30/11/14.
 */
object Permutations {
  def fact(n: Int): Int = {
    if (n <= 1) 1
    else n * fact(n-1)
  }

  def getMultiple(factorial: Int, multiple: Int, limit: Int): Int = {
    if(factorial*multiple < limit) getMultiple(factorial, multiple+1, limit)
    else multiple
  }

  def permutationsUtil(list: List[Int], limit: Int, soFar: String): String = {
    val factorial = fact(list.size - 1)
    val index = getMultiple(factorial, 1, limit)
    val remainingList = list.take(index-1) ++ list.drop(index)
    if (factorial * index == limit) soFar + list(index-1) + remainingList.sortWith((x, y) => x > y).mkString
    else permutationsUtil(remainingList, limit-factorial*(index-1), soFar+list(index-1))
  }

  def permutations(list: List[Int], limit: Int): String = {
    permutationsUtil(list.sorted, limit, "")
  }

  def main (args: Array[String]) {
    println(permutations(List(1,2,3,4),10))
    println(permutations(List(4,1,2,3),10))
    println(permutations((0 to 9).toList, 1000000))
  }
}

/**
 * Created by shweta on 26/11/14.
 */
object Multiples {
  def sum(n1:Int, n2:Int): Int = {
    n1 + n2
  }

  def multiple(no:Int, n1:Int, n2:Int):Int = {
    if (no%n1 == 0 || no%n2 == 0) no
    else 0
  }

  def multiples(n1:Int, n2:Int, highest:Int): Int = {
    ((0 to highest).toList).map(multiple(_,n1,n2)).reduce(sum)
  }

  def main (args: Array[String]) {
    println(multiples(3,5,10))
    println(multiples(3,5,1000))
  }
}

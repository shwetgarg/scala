/**
 * Created by shweta on 25/11/14.
 */
object Reverse {
  def reverse(list: List[Int]): List[Int] = {
    def reverseUtil(list: List[Int], sofar: List[Int]): List[Int] = {
      list match {
        case Nil => sofar
        case head :: tail => reverseUtil(tail, head :: sofar)
      }
    }

    reverseUtil(list, Nil)
  }

  def main (args: Array[String]) {
    println(reverse(List(1,2,3)))
    println(reverse(List(1,2,3,4,5,6)))
  }

}

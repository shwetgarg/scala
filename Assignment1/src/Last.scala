/**
 * Created by shweta on 25/11/14.
 */
object Last {
  def last(list : List[Int]) : Int = {
    list match {
      case Nil => throw new IllegalArgumentException
      case head :: Nil => head
      case head :: tail => last(tail)
    }
  }

  def main (args: Array[String]) {
    println(last(List(1,2,3)))
    println(last(List(1,2)))
    println(last(List(1)))
  }

}

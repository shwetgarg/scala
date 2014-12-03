/**
 * Created by shweta on 25/11/14.
 */
object Penultimate {
  def penultimate(list : List[Int]): Int = {
    list match {
      case Nil => throw new IllegalArgumentException
      case head :: Nil => throw new IllegalArgumentException
      case head :: tail :: Nil => head
      case head :: tail => penultimate(tail)
    }
  }

  def main (args: Array[String]) {
    println(penultimate(List(1,2,3)))
    println(penultimate(List(1,2)))
  }
}

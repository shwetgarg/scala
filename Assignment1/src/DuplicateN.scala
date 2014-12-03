/**
 * Created by shweta on 25/11/14.
 */
object DuplicateN {
  def duplicateN(times: Int, list: List[Char]): List[Char] = {
    def duplicateNUtil(count: Int, times: Int, list: List[Char]): List[Char] = {
      list match {
        case Nil => Nil
        case head :: tail if times < 0 => sys.error("noOfTimes cannot be negative")
        case head :: tail if times == 0 => List()
        case head :: tail if count == times => head.toChar :: duplicateNUtil(1, times, tail)
        case head :: tail => head.toChar :: duplicateNUtil(count + 1, times, list)
      }
    }
    duplicateNUtil(1, times, list)
  }

  def duplicateNTail(times: Int, list: List[Char]): List[Char] = {
    def duplicateNTailUtil(count: Int, times: Int, list: List[Char], sofar: List[Char]): List[Char] = {
      list match {
        case Nil => sofar
        case head :: tail if times < 0 => sys.error("noOfTimes cannot be negative")
        case head :: tail if times == 0 => List()
        case head :: tail if count == times => duplicateNTailUtil(1, times, tail, sofar ++ List(head))
        case head :: tail => duplicateNTailUtil(count + 1, times, list, sofar ++ List(head))
      }
    }
    duplicateNTailUtil(1, times, list, Nil)
  }

  def main (args: Array[String]) {
    println(duplicateN(3, List('a', 'b', 'c')))
    println(duplicateN(0, List('a', 'b', 'c')))
//    println(duplicateN(-1, List('a', 'b', 'c')))

    println(duplicateNTail(3, List('a', 'b', 'c')))
    println(duplicateNTail(0, List('a', 'b', 'c')))
    //    println(duplicateN(-1, List('a', 'b', 'c')))
  }
}

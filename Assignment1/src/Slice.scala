/**
 * Created by shweta on 26/11/14.
 */
object Slice {
  def slice(start: Int, end: Int, list: List[Char]): List[Char] = {
    def sliceUtil(count: Int, start: Int, end: Int, list: List[Char], result: List[Char]): List[Char] = {
      list match {
        case Nil => result
        case head :: tail if start > end => sys.error("start cannot be greater than end")
        case head :: tail if count > start && count <= end => sliceUtil(count+1, start, end, tail, result ++ List(head))
        case head :: tail if count <= start => sliceUtil(count+1, start, end, tail, result)
        case head :: tail if count > end => result
      }
    }
    sliceUtil(1, start, end, list, Nil)
  }

  def main (args: Array[String]) {
    println(slice(3, 7, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))
    println(slice(3, 12, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))
//    println(slice(7, 3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))

  }
}

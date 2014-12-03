/**
 * Created by shweta on 25/11/14.
 */
object Compress {
  def compress(list: List[Char]): List[Char] = {
    def compressUtil(list: List[Char], prev: Char): List[Char] = {
      list match {
        case Nil => Nil
        case head :: tail if head == prev => compressUtil(tail, head)
        case head :: tail => head :: compressUtil(tail, head)
      }
    }
    compressUtil(list, 0.toChar)
  }

  def compressTail(list: List[Char]): List[Char] = {
    def compressTailUtil(list: List[Char], prev: Char, result: List[Char]): List[Char] = {
      list match {
        case Nil => result
        case head :: tail if head == prev => compressTailUtil(tail, head, result)
        case head :: tail => compressTailUtil(tail, head, result ++ List(head))
      }
    }
    compressTailUtil(list, '\0', Nil)
  }

  def main (args: Array[String]) {
    println(compress(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')))
    println(compress(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'd', 'e', 'e', 'e')))

    println(compressTail(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')))
    println(compressTail(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'd', 'e', 'e', 'e')))
  }
}

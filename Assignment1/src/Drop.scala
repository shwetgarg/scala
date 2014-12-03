/**
 * Created by shweta on 26/11/14.
 */
object Drop {
  def drop(N: Int, list: List[Char]): List[Char] = {
    def dropUtil(count: Int, N: Int, list: List[Char]): List[Char] = {
      list match {
        case Nil => Nil
        case head :: tail if N <= 0 => sys.error("N cannot be 0 or negative")
        case head :: tail if count == N => dropUtil(1, N, tail)
        case head :: tail => head :: dropUtil(count + 1, N, tail)
      }
    }
    dropUtil(1, N, list)
  }

  def dropTail(N: Int, list: List[Char]): List[Char] = {
    def dropTailUtil(count: Int, N: Int, list: List[Char], result: List[Char]): List[Char] = {
      list match {
        case Nil => result
        case head :: tail if N <= 0 => sys.error("N cannot be 0 or negative")
        case head :: tail if count == N => dropTailUtil(1, N, tail, result)
        case head :: tail => dropTailUtil(count + 1, N, tail, result ++ List(head))
      }
    }
    dropTailUtil(1, N, list, Nil)
  }

  def main (args: Array[String]) {
    println(drop(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))
//    println(drop(0, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))

    println(dropTail(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))
    //    println(drop(0, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')))

  }
}

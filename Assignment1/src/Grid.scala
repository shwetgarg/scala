import scala.collection.mutable

/**
 * Created by shweta on 27/11/14.
 */
object Grid {
  def grid(row: Int, col: Int): Int = {
    def gridUtil(row: Int, col: Int, curRow: Int, curCol: Int): Int = {
      if (curRow == row && curCol == col) 1
      else if (curRow == row && curCol < col) gridUtil(row, col, curRow, curCol+1)
      else if (curRow < row && curCol == col) gridUtil(row, col, curRow+1, curCol)
      else gridUtil(row, col, curRow+1, curCol) + gridUtil(row, col, curRow, curCol+1)
    }
    gridUtil(row, col, 0, 0)
  }

  def gridDP(row: Int, col: Int): Int = {
    var map = mutable.Map((0,0)->1)
    for (curRow <- 0 to row) {
      for (curCol <- 0 to col) {
        if ((curRow == 0) && (curCol == 0)) map((curRow, curCol)) = 1
        else if (curRow == 0) map((curRow, curCol)) = map((curRow, curCol-1))
        else if (curCol == 0) map((curRow, curCol)) = map((curRow-1, curCol))
        else map((curRow, curCol)) = map((curRow, curCol-1)) + map((curRow-1, curCol))
      }
    }
    map((row, col))
  }

  def main (args: Array[String]) {
    println(grid(2,2))
    println(grid(10,10))
    println(grid(15,15))
//    println(grid(20,20))

    println()
    println(gridDP(2,2))
    println(gridDP(10,10))
    println(gridDP(15,15))
    println(gridDP(20,20))
  }
}

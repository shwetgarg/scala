/**
 * Created by shweta on 25/11/14.
 */
object FullWords {

  def fullWords (num:Int): String = {
    def fullWordsUtil (num:Int, sofar:String): String = {

      var temp:String = sofar
      if (sofar != "") temp = "-" + sofar

      (num%10) match {
        case 0 => sofar
        case 1 => fullWordsUtil(num/10, "one" + temp)
        case 2 => fullWordsUtil(num/10, "two" + temp)
        case 3 => fullWordsUtil(num/10, "three" + temp)
        case 4 => fullWordsUtil(num/10, "four" + temp)
        case 5 => fullWordsUtil(num/10, "five" + temp)
        case 6 => fullWordsUtil(num/10, "six" + temp)
        case 7 => fullWordsUtil(num/10, "seven" + temp)
        case 8 => fullWordsUtil(num/10, "eight" + temp)
        case 9 => fullWordsUtil(num/10, "nine" + temp)
      }
    }
    fullWordsUtil(num, "")
  }

  def main (args: Array[String]) {
    println(fullWords(179))
    println(fullWords(243))
  }

}

/**
 * Created by shweta on 27/11/14.
 */
object Prime {
  def generateComposite(prime:Int, multiple: Int, end: Int, sofar: Set[Int]):Set[Int] = {
    if (prime*multiple <= end) generateComposite(prime, multiple+1, end, sofar ++ Set(prime*multiple))
    else sofar
}

  def generatePrimes(current: Int, end: Int, primeList: List[Int], compositeList: Set[Int]): List[Int] = {
    if (current == end+1) primeList
    else if (compositeList contains current) generatePrimes(current + 1, end, primeList, compositeList ++ generateComposite(current, 2, end, compositeList))
    else generatePrimes(current + 1, end, primeList ++ List(current), compositeList ++ generateComposite(current, 2, end, compositeList))
  }

  def listPrimesinRange(start: Int, end: Int): List[Int] = {
    generatePrimes(2, end, List(), Set()).dropWhile(_ < start)
  }

  def main(args: Array[String]) {
    println(listPrimesinRange(7, 31))
  }
}


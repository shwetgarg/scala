/**
 * Created by shweta on 3/12/14.
 */

object RemoteControl {
//  def f(state: State, )
//  def getMinClicks(startState: State, toViewChannels: List[Int]) : Int = {
//    toViewChannels.foldLeft((startState, 0))(f)._2
//  }

  def getMinClicks(navigator: Go, toViewChannels: List[Int]): Int = {
    def getMinClicksUtil(navigator: Go, toViewChannels: List[Int], clickSoFar: Int): Int = {
      if (toViewChannels.isEmpty) clickSoFar
      else {
        val tuple = navigator.goInMin(toViewChannels.head)
        getMinClicksUtil(Go(tuple._1), toViewChannels.tail, clickSoFar + tuple._2)
      }
    }
    getMinClicksUtil(navigator, toViewChannels, 0)
  }

  def main (args: Array[String]) {
    val lowestChannel = 1
    val highestChannel = 20
    val noOfBlockedChannels = 2
    val blockedChannels = Set(18, 19)
    val noOfViewChannels = 5
    val toViewChannels = List(5, 15, 14, 17, 1, 17)

    val startState = new State(toViewChannels.head, toViewChannels.head, lowestChannel, highestChannel, blockedChannels)  // (5,5,1,20,Set(18,19))

    getMinClicks(Go(startState), toViewChannels.tail)
  }
}

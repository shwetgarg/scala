/**
 * Created by shweta on 3/12/14.
 */
case class State(current: Int, previous:Int, lowest: Int, highest: Int, blockedChannels: Set[Int])
{
  def up: State = {
    if ((current + 1 > highest) || (blockedChannels contains current + 1)) copy(current = current + 1).up
    else this
  }

  def down: State = {
    if ((current - 1 < lowest) || (blockedChannels contains current - 1)) copy(current = current - 1).down
    else this
  }

  def back: State = {
    copy(current = previous, previous = current)
  }

  def set(channel: Int) : State = {
    copy(previous = current, current = channel)
  }
}
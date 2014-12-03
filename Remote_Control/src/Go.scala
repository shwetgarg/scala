/**
 * Created by shweta on 3/12/14.
 */
case class Go(state: State)
{
  def goUp(currentState: State, nextChannel: Int, clicksSoFar: Int): (State, Int) = {
    currentState match  {
      case State(current, _, _, _, _) if current == nextChannel => (currentState, clicksSoFar)
      case State(current, _, _, _, _) => {println(current)
        goUp(state.up, nextChannel, clicksSoFar+1)
        }
    }
  }

  def goDown(currentState: State, nextChannel: Int, clicksSoFar: Int): (State, Int) = {
    currentState match  {
      case State(current, _, _, _, _) if current == nextChannel => (currentState, clicksSoFar)
      case State(current, _, _, _, _) => goDown(state.down, nextChannel, clicksSoFar+1)
    }
  }

  def goBack(currentState: State): (State, Int) = {
    (currentState.back, 1)
  }

  def goDirect(currentState: State, nextChannel: Int): (State, Int) = {
    (currentState.set(nextChannel), nextChannel.toString.size)
  }

  def goInMin(nextChannel: Int): (State, Int) =
  {
    List(goUp(state, nextChannel, 0), goDown(state, nextChannel, 0), goBack(state), goDirect(state, nextChannel)).minBy(_._2)
  }
}

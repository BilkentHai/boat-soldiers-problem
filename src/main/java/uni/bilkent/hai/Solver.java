package uni.bilkent.hai;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by eliztekcan on 9.03.2017.
 * Searches for the solution of the problem in the state tree using BFS
 */
public class Solver {

    HashMap<State,State> map = new HashMap<State, State>();
    String result = "";

    public State BFS(State start) {
        Queue<State> q = new LinkedList<State>();
        List<State> visited = new LinkedList();
        q.add(start);
        visited.add(start);
        while(!q.isEmpty() ){
            State curState = (State) q.remove();
            result += ( curState.toString() + "\n");
            if( isSolution(curState)){
                visited.add(curState);
                return curState;
            }
            else{
                List<State> neighbors = curState.getNeighborStates();
                for (State s: neighbors) {

                    if (!map.containsKey(s)) {
                        map.put(s, curState);
                    }
                }
                q.addAll(curState.getNeighborStates());
            }
            visited.add(curState);
        }
        return null;
    }

    private boolean isSolution(State curState) {
        RiverSide side = curState.getBoat().getRiverSide();
        if(curState.getGoal().getNumberOfSoldiers() == 3 ){
            if(side == RiverSide.GOAL) {
                if (curState.getGoal().getNumberOfBoys() ==2 ){
                    //System.out.println("Solution found :" + curState.toString());
                    return true;
                }
            }
            if(side == RiverSide.START) {
                if (curState.getStart().getNumberOfBoys() ==2 ) {
                    //System.out.println("Solution found :" + curState.toString());
                    return true;
                }
            }
        }
        return false;
    }

    public String JSONifySolution(State solution)
    {
        String path = "";
        State cur = solution;
        while (map.containsKey(cur)) {
            path = "\"" + cur.getid() + "\", " + path;
            State temp = map.get(cur);
            cur = map.get(cur);
        }
        return path;
    }

    public void printSearch()
    {
        System.out.println( result);
    }


    public static void main(String[] args) {

    }

}
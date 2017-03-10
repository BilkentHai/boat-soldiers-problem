package uni.bilkent.hai;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by eliztekcan on 9.03.2017.
 */
public class Solver {

    HashMap<State,State> map = new HashMap<State, State>();

    public State BFS(State start) {
        Queue<State> q = new LinkedList<State>();
        List<State> visited = new LinkedList();
        q.add(start);
        visited.add(start);
        while(!q.isEmpty() ){
            State curState = (State) q.remove();
            if( isSolution(curState)){
                visited.add(curState);
                //System.out.println(visited);
                return curState;
            }
            else{
                List<State> neighbors = curState.getNeighborStates();
                for (State s: neighbors) {

                    if (!map.containsKey(s)) {
                        System.out.println( curState + " -> " + s + "\n");
                        map.put(s, curState);
                    }
                }
                q.addAll(curState.getNeighborStates());
            }
            visited.add(curState);
        }	//predecessor state of the original state is equal to itself
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

    private void printSolution(State solution, State start)
    {
        State cur = solution;
        while (map.containsKey(cur)) {
            System.out.println(map.get(cur));
            State temp = map.get(cur);
            cur = map.get(cur);
        }

    }

    public static void main(String[] args) {
        Solver solver = new Solver();
        StateGenerator g;
        GraphTraverser trav = new GraphTraverser();
        g = trav.getSg();
        //System.out.println(solver.BFS(trav.getSg().getStates().get(0)));

        solver.printSolution(solver.BFS(g.getStates().get(0)), g.getStates().get(0));
        System.out.println( solver.map.size());
    }

}
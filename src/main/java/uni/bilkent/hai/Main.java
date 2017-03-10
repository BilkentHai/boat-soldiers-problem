package uni.bilkent.hai;

/**
 * Created by eliztekcan on 11.03.2017.
 *
 * Driver program. Prints search steps to console and calls necessary functions for visualization
 */
public class Main {

    public static void main( String[] args)
    {
        GraphGenerator gg = new GraphGenerator();

        Solver solver = new Solver();
        GraphTraverser trav = new GraphTraverser();

        StateGenerator sg;
        sg = trav.getStateGenerator();
        //System.out.println(solver.BFS(trav.getStateGenerator().getStates().get(0)));

        solver.BFS( sg.getStates().get(0));
        solver.printSearch();
    }

}

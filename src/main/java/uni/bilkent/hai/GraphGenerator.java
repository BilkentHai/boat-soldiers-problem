package uni.bilkent.hai;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by eliztekcan on 9.03.2017.
 *
 * Generates JSON form of graph for visualisation
 */
public class GraphGenerator {

    GraphTraverser trav;
    String nodes, edges;
    Solver solver;
    String solution;
    String searchPath;

    private List<State> states = new ArrayList<State>();

    public GraphGenerator()
    {
        solver = new Solver();
        trav = new GraphTraverser();
        states = trav.getStateGenerator().getStates();
        List<State> neighborstates;
        nodes = "[ ";
        edges = "[ ";
        // TODO: give classes property to goal & start nodes
        for(int i = 0; i < states.size(); i++){
            State curState = states.get(i);
            neighborstates = curState.getNeighborStates();
            nodes += "{ \"data\": { \"id\": \"" + curState.getid() + "\",";
            nodes += "\"content\": \"((" ;

            if(curState.getStart().getNumberOfBoys() != 0)
            {
                nodes += curState.getStart().getNumberOfBoys() + " Boy ";
            }

            if(curState.getStart().getNumberOfSoldiers() != 0)
            {
                nodes += curState.getStart().getNumberOfSoldiers() + " Soldier";
            }

            if( curState.getBoat().getRiverSide() ==RiverSide.START){
                nodes += " Boat";
            }
            nodes += ") (";

            if(curState.getGoal().getNumberOfBoys() != 0)
            {
                nodes += curState.getGoal().getNumberOfBoys() + " Boy ";
            }

            if(curState.getGoal().getNumberOfSoldiers() != 0)
            {
                nodes += curState.getGoal().getNumberOfSoldiers() + " Soldier";
            }

            if( curState.getBoat().getRiverSide() ==RiverSide.GOAL){
                nodes += " Boat";
            }

            nodes += "))\" } }";
            if(i != states.size()-1)
            {
                nodes += ",";
            }
            for(int j = 0; j < neighborstates.size(); j++) {
                edges += "{ \"data\": { \"source\": \"" + curState.getid() + "\",\"target\": \""
                        + neighborstates.get(j).getid() + "\" } },";
            }

        }
        nodes += "]";
        edges = edges.substring(0, edges.length()-1);
        edges += "]";
        solution = "[";
        solution += solver.JSONifySolution(solver.BFS( trav.getStateGenerator().getStates().get(0)), trav.getStateGenerator().getStates().get(0));
        solution = solution.substring(0,solution.length()-2);
        solution += "]";
        searchPath = solver.getSearchPath();
        searchPath = searchPath.substring(0, searchPath.length()-3);
        searchPath += "]";
        //System.out.println(solution);
        JSONFile();

    }

    public void JSONFile(){
            try {
                File file = new File("web/edges.json");
                File file2 = new File("web/nodes.json");
                File file3 = new File("web/solution.json");
                File file4 = new File("web/search_path.json");
                file.createNewFile();
                file2.createNewFile();
                file3.createNewFile();
                file4.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                FileWriter fileWriter2 = new FileWriter(file2);
                FileWriter fileWriter3 = new FileWriter(file3);
                FileWriter fileWriter4 = new FileWriter(file4);
                fileWriter3.write(solution);
                fileWriter3.flush();
                fileWriter3.close();
                fileWriter4.write(searchPath);
                System.out.println(searchPath);
                fileWriter4.flush();
                fileWriter4.close();
                fileWriter.write( edges);
                fileWriter2.write( nodes);
                fileWriter.flush();
                fileWriter.close();
                fileWriter2.flush();
                fileWriter2.close();
            } catch ( IOException e){
                e.printStackTrace();;
            }
    }

}
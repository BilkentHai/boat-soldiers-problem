package uni.bilkent.hai;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by eliztekcan on 9.03.2017.
 */
public class GraphGenerator {

    StateGenerator stateGenerator;
    String nodes, edges;

    private List<State> states = new ArrayList<State>();

    public GraphGenerator()
    {
        stateGenerator = new StateGenerator();
        List<State> neighborstates;
        nodes = "[ {";
        edges = "[ {";
        states = stateGenerator.getStates();
        for(int i = 0; i < states.size(); i++){
            State curState = states.get(i);
            neighborstates = curState.getNeighborStates();
            nodes += "\"data\": { \"id\": \"" + curState.getid() + "\",";
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
                edges += "\"data\": { \"source\": \"" + curState.getid() + "\",\"target\": "
                        + neighborstates.get(j).getid() + "\" } },";
            }

        }
        nodes += "]";
        edges = edges.substring(0, edges.length()-1);
        edges += "]";
        JSONFile();

    }

    public void JSONFile(){
            try {
                File file = new File("edges.json");
                File file2 = new File("nodes.json");
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                FileWriter fileWriter2 = new FileWriter(file2);
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

    public static void main(String[] args) {
        GraphGenerator g = new GraphGenerator();
        System.out.println(g.nodes);
        System.out.println(g.edges);
    }

}
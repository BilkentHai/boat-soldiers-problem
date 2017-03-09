package uni.bilkent.hai;

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
                nodes += curState.getStart().getNumberOfBoys() + " Boy";
            }
            if(curState.getStart().getNumberOfSoldiers() != 0)
            {
                nodes += "," + curState.getStart().getNumberOfSoldiers() + " Soldier";
            }
            nodes += ") (";
            if(curState.getGoal().getNumberOfBoys() != 0)
            {
                nodes += curState.getGoal().getNumberOfBoys() + " Boy";
            }
            if(curState.getGoal().getNumberOfSoldiers() != 0)
            {
                nodes += "," + curState.getGoal().getNumberOfSoldiers() + " Soldier";
            }
            nodes += "))\" } }";
            if(i != states.size()-1)
            {
                nodes += ",";
            }
            for(int j = 0; j < neighborstates.size(); j++) {
                edges += "\"data\": { \"source\": \"" + curState.getid() + "\",\"target\": "
                        + neighborstates.get(j).getid() + "\" } }";
                if(j != neighborstates.size()-1)
                {
                    edges += ",";
                }
            }
        }
        nodes += "]";
        edges += "]";


    }
}

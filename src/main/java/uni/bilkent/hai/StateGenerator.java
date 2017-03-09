package uni.bilkent.hai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrsfy on 05-Mar-17.
 */
public class StateGenerator {

    private int numberOfBoys = 2;
    private int numberOfSoldiers = 3;

    private List<State> states = new ArrayList<State>();


    public StateGenerator() {

        for (int i = 0; i <= numberOfBoys; i++)
            for (int j = 0; j <= numberOfSoldiers; j++)
                for (RiverSide boatSide : RiverSide.values())
                    states.add(new State(numberOfBoys - i, numberOfSoldiers - j, i, j, boatSide));


        for (int i = 0; i < states.size(); i++) {
            for (int j = i + 1; j < states.size(); j++) {
                State s1 = states.get(i);
                State s2 = states.get(j);

                int boys = Math.abs(s1.getGoal().getNumberOfBoys() - s2.getGoal().getNumberOfBoys());
                int soldiers = Math.abs(s1.getGoal().getNumberOfSoldiers() - s2.getGoal().getNumberOfSoldiers());

                if (s1.getBoat().getRiverSide() == s2.getBoat().getRiverSide())
                    continue;
                else if (s2.getBoat().getRiverSide() == RiverSide.GOAL && (s2.getGoal().getNumberOfSoldiers() - s1.getGoal().getNumberOfSoldiers() < 0
                        || s2.getGoal().getNumberOfBoys() - s1.getGoal().getNumberOfBoys() < 0))
                    continue;
                else if (s2.getBoat().getRiverSide() == RiverSide.START && (s2.getStart().getNumberOfSoldiers() - s1.getStart().getNumberOfSoldiers() < 0
                        || s2.getStart().getNumberOfBoys() - s1.getStart().getNumberOfBoys() < 0))
                    continue;
                else if ((boys <= 2 && boys >= 1 && soldiers == 0) || (boys == 0 && soldiers == 1)){
                    s1.addNeighborState(s2);
                    s2.addNeighborState(s1);
                    System.out.println("State " + i);
                    System.out.println(s1);
                    System.out.println("State " + j);
                    System.out.println(s2);
                    System.out.println("-----------");
                }
            }
        }


    }

    public int getNumberOfBoys() {
        return numberOfBoys;
    }

    public void setNumberOfBoys(int numberOfBoys) {
        this.numberOfBoys = numberOfBoys;
    }

    public int getNumberOfSoldiers() {
        return numberOfSoldiers;
    }

    public void setNumberOfSoldiers(int numberOfSoldiers) {
        this.numberOfSoldiers = numberOfSoldiers;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public static void main(String[] args) {
        new StateGenerator();
    }

}

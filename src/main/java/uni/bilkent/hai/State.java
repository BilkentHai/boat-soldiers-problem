package uni.bilkent.hai;

import java.util.ArrayList;
import java.util.List;


public class State {

    private SideOfRiver start, goal;
    private Boat boat;
    private List<State> neighborStates;

    public State(int startNumberOfBoys, int startNumberOfSoldiers, int goalNumberOfBoys, int goalNumberOfSoldiers, RiverSide boatSide) {
        start = new SideOfRiver(startNumberOfBoys, startNumberOfSoldiers);
        goal = new SideOfRiver(goalNumberOfBoys, goalNumberOfSoldiers);
        boat = new Boat(boatSide);
        neighborStates = new ArrayList<State>();
    }

    public void addNeighborState(State state) {
        neighborStates.add(state);
    }


    public SideOfRiver getStart() {
        return start;
    }

    public void setStart(SideOfRiver start) {
        this.start = start;
    }

    public SideOfRiver getGoal() {
        return goal;
    }

    public void setGoal(SideOfRiver goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "Start boys: " + start.getBoys().size() + "\n"
                + "Start soldiers: " + start.getSoldiers().size() + "\n"
                + "Goal boys: " + goal.getBoys().size() + "\n"
                + "Goal soldiers: " + goal.getSoldiers().size() + "\n"
                + "Side of boat: " + boat.getRiverSide();
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}

package uni.bilkent.hai;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;


public class State {

    private SideOfRiver start, goal;
    private Boat boat;
    private List<State> neighborStates;
    private String id;

    public State(int startNumberOfBoys, int startNumberOfSoldiers, int goalNumberOfBoys, int goalNumberOfSoldiers, RiverSide boatSide) {
        start = new SideOfRiver(startNumberOfBoys, startNumberOfSoldiers);
        goal = new SideOfRiver(goalNumberOfBoys, goalNumberOfSoldiers);
        boat = new Boat(boatSide);
        neighborStates = new ArrayList<State>();
        id = randomUUID().toString();
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

    public String getid() { return id;}

    public List<State> getNeighborStates() {
        return neighborStates;
    }

    public void setNeighborStates(List<State> neighborStates) {
        this.neighborStates = neighborStates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}

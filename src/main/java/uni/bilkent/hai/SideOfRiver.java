package uni.bilkent.hai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrsfy on 05-Mar-17.
 */
public class SideOfRiver {


    private List<Soldier> soldiers = new ArrayList<Soldier>();
    private List<Boy> boys = new ArrayList<Boy>();

    public SideOfRiver(int numberOfBoys, int numberOfSoldiers) {
        for (int i = 0; i < numberOfBoys; i++)
            boys.add(new Boy());

        for (int i = 0; i < numberOfSoldiers; i++)
            soldiers.add(new Soldier());
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public List<Boy> getBoys() {
        return boys;
    }

    public int getNumberOfBoys() {
        return boys.size();
    }

    public int getNumberOfSoldiers() {
        return soldiers.size();
    }

    public void setBoys(List<Boy> boys) {
        this.boys = boys;
    }

    @Override
    public String toString() {
        return "SideOfRiver{" +
                "soldiers = " + soldiers +
                ", boys = " + boys +
                '}';
    }
}

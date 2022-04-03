package Function;

import Data.Unit;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Army {
    private String name;
    private List<Unit> units;

    /**
     * Basic constructor which create new army
     * @param name name of the army
     */
    public Army(String name){
        this.name = name;
        units = new ArrayList<>();
    }

    /**
     * Constructor for a army
     * @param name the name of the army
     * @param units a list with units to put inside this army
     */
    public Army(String name, List<Unit> units){
        this.name = name;
        this.units = units;
    }

    /**
     * Get name of this army
     * @return name of the army
     */
    public String getName(){
        return this.name;
    }

    /**
     * Add a unit to this army
     * @param unit the unit you want to add
     */
    public void add(Unit unit){
        units.add(unit);
    }

    /**
     * Add all units in a list to an army
     * @param units list of units you want to add
     */
    public void addAll(List<Unit> units){
        if(!units.isEmpty()) {
            for (Unit u : units) {
                this.units.add(u);
            }
        }
    }

    /**
     * Remove a unit from the army
     * @param unit the unit you want to remove
     */
    public void remove(Unit unit){
        for (Unit u : this.units){
            if(u==unit){
                units.remove(u);
            }
        }
    }

    /**
     * Check if this army contains any units
     * @return true if this army contains units
     */
    public boolean hasUnit(){
        boolean isFull = false;
        if(!this.units.isEmpty()){
            isFull = true;
        }
        return isFull;
    }

    /**
     * Get all units in a list
     * @return list with all units
     */
    public List<Unit> getAllUnits(){
        return this.units;
    }

    /**
     * Get a random unit from army
     * @return random unit from army
     */
    public Unit getRandomUnit(){
        Random random = new Random();
        int index = random.nextInt();
        return this.units.get(index);
    }

    @Override
    public String toString() {
        return "Army{" +
                "name='" + name + '\'' +
                ", units=" + units +
                '}';
    }

    /**
     * Check if army contains a specific unit
     * @param object the object you want to search for
     * @return true if it contains object
     */
    public boolean equals(Object object){
        /**boolean equals = false;
        for (Unit u: this.units) {
            if(u==object){
                equals = true;
            }
        }
        return equals;*/
        return units.contains(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }
}

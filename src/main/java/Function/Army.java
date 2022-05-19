package Function;

import Data.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

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
     * Constructor for an army
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

    /**
     * Get infantry units in this army.
     *
     * @return list with infantry units in this army
     */
    public List<Unit> getInfatryUnits(){
        InfantryUnit unit = new InfantryUnit("10",10);
        List<Unit> units = this.units.stream().
                filter(u->u.getClass()==unit.getClass()).
                collect(Collectors.toList());

        return units;
    };

    /**
     * Get the cavalry units in this army.
     *
     * @return list of cavalry units in this army
     */
    public List<Unit> getCavalryUnits(){
        CavalryUnit unit = new CavalryUnit("10",10);
        List<Unit> units = this.units.stream().
                filter(u->u.getClass()==unit.getClass()).
                collect(Collectors.toList());

        return units;
    };

    /**
     * Get the ranged units in this army.
     *
     * @return list with the ranged units in the army
     */
    public List<Unit> getRangedUnits(){
        RangedUnit unit = new RangedUnit("10",10);
        List<Unit> units = this.units.stream().
                filter(u->u.getClass()==unit.getClass()).
                collect(Collectors.toList());

        return units;
    };

    /**
     * Get the commander units in this army.
     *
     * @return list of commander units in the army
     */
    public List<Unit> getCommanderUnits(){
        CommanderUnit unit = new CommanderUnit("10",10);
        List<Unit> units = this.units.stream().
                filter(u->u.getClass()==unit.getClass()).
                collect(Collectors.toList());

        return units;
    };


}

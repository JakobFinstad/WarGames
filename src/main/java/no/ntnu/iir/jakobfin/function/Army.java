package no.ntnu.iir.jakobfin.function;


import no.ntnu.iir.jakobfin.data.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * A class that handles multiple units. With som basic methods to handle the units in this army.
 *
 * @author 10007
 * @version 24.04.2022
 */
public class Army {
    private String name;
    private List<Unit> units;

    /**
     * Basic constructor which create new army.
     *
     * @param name name of the army
     */
    public Army(String name){
        this.name = name;
        units = new ArrayList<>();
    }

    /**
     * Constructor for an army.
     *
     * @param name the name of the army
     * @param units a list with units to put inside this army
     */
    public Army(String name, List<Unit> units){
        this.name = name;
        this.units = units;
    }

    /**
     * Get name of this army.
     *
     * @return name of the army
     */
    public String getName(){
        return this.name;
    }

    /**
     * Add a unit to this army.
     *
     * @param unit the unit you want to add
     */
    public void add(Unit unit){
        units.add(unit);
    }

    /**
     * Add all units in a list to an army.
     *
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
     * Remove a unit from the army.
     *
     * @param unit the unit you want to remove
     */
    public void remove(Unit unit){
        if(this.units.contains(unit)){
            this.units.remove(unit);
        }
    }

    /**
     * Check if this army contains any units.
     *
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
     * Get all units in a list.
     *
     * @return list with all units
     */
    public List<Unit> getAllUnits(){
        return this.units;
    }

    /**
     * Get a random unit from army.
     *
     * @return random unit from army
     */
    public Unit getRandomUnit(){
        Random random = new Random();
        int index = random.nextInt(this.getAllUnits().size());
        return this.units.get(index);
    }

    @Override
    public String toString() {
        return "Army{" +
                "name='" + name + '\'' +
                ", units=" + units +
                '}';
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

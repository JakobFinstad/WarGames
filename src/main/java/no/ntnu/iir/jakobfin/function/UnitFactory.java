package function;

import data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to create units with given parameters. This makes it easier to create multiple units of same type and create
 * simple units.
 *
 * @author 10007
 * @version 01.05.2022
 */
public class UnitFactory {

    /**
     * Create unit by given type of unit, name and health.
     *
     * @param unitType the unit type that shall be created, must be with first letter in each word with capital letters
     * @param name the name of the unit that shall be created
     * @param health the amount of hitpoints to this unit
     * @return the unit that was created, or null if the unit was not created
     */
    public Unit createUnit(String unitType ,String name, int health ){
        Unit unit = null;
        if(unitType.equals("InfantryUnit")){
            unit = new InfantryUnit(name,health);
        }

        if(unitType.equals("RangedUnit")){
            unit = new RangedUnit(name,health);
        }

        if(unitType.equals("CavalryUnit")){
            unit = new CavalryUnit(name,health);
        }

        if(unitType.equals("CommanderUnit")){
            unit = new CommanderUnit(name, health);
        }

        return unit;
    }

    /**
     * Create multiple units of one type. Create given number of units with the entered parameters.
     *
     * @param unitType the type of the units that shall be created, have to start each words with capitol letter
     * @param name the name of the units that shall be created
     * @param health the amount of hitpoints that the unit has
     * @param numberOfUnits the number of units that shall be created
     * @return list with the units that has been created, return empty list if the unit type was wrong
     */
    public List<Unit> createMultipleUnits(String unitType, String name, int health, int numberOfUnits){
        List<Unit> units = new ArrayList<>();
        for(int i=0;i<numberOfUnits;i++){
            units.add(createUnit(unitType,name,health));
        }

        return units;
    }
}

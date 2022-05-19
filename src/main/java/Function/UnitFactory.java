package Function;

import Data.*;

import java.util.ArrayList;
import java.util.List;

public class UnitFactory {

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

    public List<Unit> createMultipleUnits(String unitType, String name, int health, int number){
        List<Unit> units = new ArrayList<>();
        for(int i=0;i<number;i++){
            createUnit(unitType,name,health);
        }

        return units;
    }
}

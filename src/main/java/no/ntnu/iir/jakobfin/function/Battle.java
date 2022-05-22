package no.ntnu.iir.jakobfin.function;

import no.ntnu.iir.jakobfin.data.Biomes;
import no.ntnu.iir.jakobfin.data.Unit;

/**
 * A class that handle the battle between two armies. Each army gets to defend and attack for each iteration.
 * The winner will be picked out when the battle stops due to one of the armies are empty.
 *
 * @author 10007
 * @version 03.03.2022
 */
public class Battle {
    private Army armyOne;
    private Army armyTwo;

    /**
     * Battle between two armies. The army one have a small advantage, but the battle is fairly square.
     *
     * @param armyOne the first army with the slight advantage
     * @param armyTwo the second army to battle
     * @param terrain the terrain the armies are battling in
     */
    public Battle(Army armyOne, Army armyTwo, Biomes terrain){
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;

        for(Unit u:this.armyOne.getAllUnits()){
            u.setTerrain(terrain);
        }

        for(Unit u:this.armyTwo.getAllUnits()){
            u.setTerrain(terrain);
        }
    }

    /**
     * Simulate a battle between 4 units and deletes the units that get reduced health to 0. This will
     * continue until one of the army are empty.
     *
     * @return winner of the battle, the army who has one or more units left after the battle
     */
    public Army simulate(){
        Army winner = null;

        while(armyOne.hasUnit()&& armyTwo.hasUnit()){
            Unit armyOneAttacker = armyOne.getRandomUnit();
            Unit armyOneDefender = armyOne.getRandomUnit();
            Unit armyTwoAttacker = armyTwo.getRandomUnit();
            Unit armyTwoDefender = armyTwo.getRandomUnit();

            armyOneAttacker.attack(armyTwoDefender);
            if(armyTwoDefender.getHealth() == 0){
                armyTwo.remove(armyTwoDefender);
            }

            if(armyTwo.getAllUnits().contains(armyTwoAttacker)) {
                armyTwoAttacker.attack(armyOneDefender);
                if (armyOneDefender.getHealth() == 0) {
                    armyOne.remove(armyOneDefender);
                }
            }


        }
        if(armyOne.hasUnit()){
            winner = armyOne;
        }
        if(armyTwo.hasUnit()){
            winner = armyTwo;
        }

        return winner;
    }

    /**
     * Get standard format for this battle. Used for debugging.
     *
     * @return string with the parameters for simple display
     */
    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                '}';
    }
}

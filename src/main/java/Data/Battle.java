package Data;

public class Battle {
    private Army armyOne;
    private Army armyTwo;

    public Battle(Army armyOne, Army armyTwo){
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    /**
     * Simulate a battle between 4 units and deletes the units that get reduced health to 0. This will
     * continue until one of the army are empty. Bruker to attackers og to defenders og håndterer at
     * uniten dør før den rekker å attacke.
     * @return winner of the battle, the army who has any units left after the battle
     */
    public Army simulate(){
        Army winner = null;

        while(armyOne.hasUnit()&& armyTwo.hasUnit()){
            Unit armyOneAttacker = armyOne.getRandomUnit();
            Unit armyOneDefender = armyOne.getRandomUnit();
            Unit armyTwoAttacker = armyTwo.getRandomUnit();
            Unit armyTwoDefender = armyTwo.getRandomUnit();

            armyOneAttacker.attack(armyTwoDefender);
            if(armyOneDefender.getHealth()==0){
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

    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                '}';
    }
}

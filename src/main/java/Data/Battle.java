package Data;

public class Battle {
    private Army armyOne;
    private Army armyTwo;

    public Battle(Army armyOne, Army armyTwo){
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

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

            armyTwoAttacker.attack(armyOneDefender);
            if(armyOneDefender.getHealth()==0){
                armyOne.remove(armyOneDefender);
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

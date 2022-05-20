package data;

/**
 * Class for cavalry units, with a few fields and some methods for further handling of the war game.
 *
 * @author 10007
 * @version 14.02.2022
 */
public class CavalryUnit extends Unit{
    /**
     * Default constructor to create a cavalryunit.
     *
     * @param name the name of this unit
     * @param health the amount of hitpoints to this unit, must be above 0
     * @param attack the attack damage to the unit
     * @param armor the amount of damage resistance'
     */
    public CavalryUnit(String name, int health, int attack, int armor){
        super(name,health,attack,armor);
    }

    /**
     * Basic constructor of this class with predetermined attack and armor.
     *
     * @param name the name of this unit
     * @param health the health of the unit, must be above 0+
     */
    public CavalryUnit(String name, int health){
        this(name,health,20,12);
    }


    /**
     * Get attack bonus of this  unit.
     *
     * @return the bonus damage
     */
    @Override
    public int getAttackBonus() {
        int attackBonus = 2;
        if(timeAttacked == 0){
            attackBonus = 6;
        }
        if(this.getTerrain()==Biomes.PLAINS){
            attackBonus+=2;
        }
        return attackBonus;
    }

    /**
     * Get resistance bonus.
     *
     * @return resistance bonus
     */
    @Override
    public int getResistanceBonus() {
        int resistBonus = 1;
        if(this.getTerrain()==Biomes.FORREST){
            resistBonus = 0;
        }
        return resistBonus;
    }
}

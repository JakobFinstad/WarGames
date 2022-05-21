package no.ntnu.iir.jakobfin.data;

/**
 * Class for infantry units, with a few fields and some methods for further handling of the war game.
 *
 * @author 10007
 * @version 10.02.2022
 */
public class InfantryUnit extends Unit{

    /**
     * Default constructor for this class.
     *
     * @param name name of then unit
     * @param health the amount of health, must be above 0
     * @param attack the amount of attack
     * @param armor resistance to this unit
     */
    public InfantryUnit(String name, int health, int attack, int armor){
        super(name,health,attack,armor);
    }

    /**
     * Simple constructor with predetermined attack and armor.
     *
     * @param name name of the unit
     * @param health the amount of hitpoints of this unit, must be above 0
     */
    public InfantryUnit(String name, int health){
        this(name,health,15,10);
    }

    /**
     * Get attack bonus of this unit, predetermined value.
     *
     * @return the attack bonus of this unit
     */
    @Override
    public int getAttackBonus() {
        int attackBonus = 2;
        if(this.getTerrain()==Biomes.FORREST){
            attackBonus = 4;
        }
        return attackBonus;
    }

    /**
     * Get the resistance bonus of the unit.
     *
     * @return the resistance of this unit
     */
    @Override
    public int getResistanceBonus() {
        int resistBonus = 1;
        if(this.getTerrain()==Biomes.FORREST){
            resistBonus = 2;
        }

        return resistBonus;
    }
}

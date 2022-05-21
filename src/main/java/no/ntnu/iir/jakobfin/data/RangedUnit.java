package no.ntnu.iir.jakobfin.data;

/**
 * Class for infantry units, with a few fields and some methods for further handling of the war game.
 *
 * @author 10007
 * @version 10.02.2022
 */
public class RangedUnit extends Unit {

    /**
     * Default constructor to this class.
     *
     * @param name the name of this unit
     * @param health the amount of hitpoints to this unit, must be above 0
     * @param attack the attack damage to the unit
     * @param armor the amount of damage resistance
     */
    public RangedUnit(String name, int health, int attack, int armor){
        super(name, health, attack, armor);
    }

    /**
     * Basic constructor of this class with predetermined attack and armor.
     *
     * @param name the name of this unit
     * @param health the health of the unit, must be above 0+
     */
    public RangedUnit(String name, int health){
        this(name,health,15,8);
    }

    /**
     * Get attack bonus of this class.
     *
     * @return attack bonus of this class when attacking
     */
    @Override
    public int getAttackBonus() {
        return 3;
    }

    /**
     * Get resistance bonus of this unit.
     *
     * @return resistance bonus for this unit
     */
    @Override
    public int getResistanceBonus() {
        int resistanceBonus = 2;
        if (timeDefended == 0){
            resistanceBonus = 6;
        }
        if(timeDefended == 1){
            resistanceBonus = 4;
        }
        if(this.getTerrain()==Biomes.HILL){
            resistanceBonus += 2;
        }else if(this.getTerrain()==Biomes.FORREST&&resistanceBonus>2){
            resistanceBonus -=1;
        }
        return resistanceBonus;
    }
}

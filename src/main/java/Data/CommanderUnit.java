package Data;

/**
 * Class for commander units, with a few fields and some methods for further handling of the war game
 *
 * @author Jakob Finstad
 * @version 14.02.2022
 */
public class CommanderUnit extends CavalryUnit {

    /**
     * Default constructor to this class
     *
     * @param name   the name of this unit
     * @param health the amount of hitpoints to this unit, must be above 0
     * @param attack the attack damage to the unit
     * @param armor  the amount of damage resistance
     */
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Basic constructor of this class with predetermined attack and armor
     *
     * @param name   the name of this unit
     * @param health the health of the unit, must be above 0+
     */
    public CommanderUnit(String name, int health) {
        this(name, health, 25, 15);
    }
}
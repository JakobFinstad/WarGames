package no.ntnu.iir.jakobfin.data;

/**
 * A class that is meant for testing of the unit class. That means that this class only has the most basic
 * that is required to extend a unit.
 *
 * @author 10007
 * @version 19.05.2022
 */
public class DummyUnit extends Unit{

    /**
     * Constructor for objects which inherits from this class.
     *
     * @param name   name of the unit
     * @param health the amount of start health to this unit
     * @param attack the amount of attack damage
     * @param armor  a value that indicates the units resistance
     */
    public DummyUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Get the attack bonus of this unit.
     *
     * @return 0, the attack bonus is only meant for functional classes
     */
    @Override
    public int getAttackBonus() {
        return 0;
    }

    /**
     * Get the resist bonus of this unit.
     *
     * @return 0, the resist bonus is only meant for functional classes
     */
    @Override
    public int getResistanceBonus() {
        return 0;
    }
}

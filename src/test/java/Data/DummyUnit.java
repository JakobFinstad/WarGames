package Data;

public class DummyUnit extends Unit{

    /**
     * Constructor for objects witch inherits from this class.
     *
     * @param name   name of the unit
     * @param health the amount of start health to this unit
     * @param attack the amount of attack damage
     * @param armor  a value that indicates the units resistance
     */
    public DummyUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    @Override
    public int getAttackBonus() {
        return 0;
    }

    @Override
    public int getResistanceBonus() {
        return 0;
    }
}

package Data;

public abstract class Unit {

    protected String name;
    protected int health;
    protected int attack;
    protected int armor;

    public abstract int getAttackBonus();

    public abstract int getResistanceBonus();

    public int getHealth(){
        
    }
}

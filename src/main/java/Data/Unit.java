package Data;

import java.util.Locale;

/**
 * Abstract class for creating instance of units, with set and get methods
 *
 * @author Jakob Finstad
 * @version 10.02.2022
 */
public abstract class Unit {

    protected String name;
    protected int health;
    protected int attack;
    protected int armor;
    protected int timeDefended = 0;
    protected int timeAttacked = 0;

    /**
     * Constructor for objects witch inherits from this class
     * @param name name of the unit
     * @param health the amount of start health to this unit
     * @param attack the amount of attack damage
     * @param armor a value that indicates the units resistance
     */
    public Unit(String name, int health, int attack, int armor) {
        this.setName(name);
        this.setHealth(health);
        this.setArmor(armor);
        this.setAttack(attack);
    }

    /**
     * Get attack bonus
     * @return attack bonus
     */
    public abstract int getAttackBonus();

    /**
     * Get resistance bonus
     * @return resistance bonus
     */
    public abstract int getResistanceBonus();

    /**
     * Get the amount of hitpoints for this unit
     * @return health of then unit
     */
    public int getHealth(){
        return this.health;
    }

    /**
     * Get time defended
     * @return how many attacks this unit has defended against
     */
    public int getTimeDefended() {
        return timeDefended;
    }

    /**
     * Get time attacked
     * @return how many times this unit has attacked
     */
    public int getTimeAttacked() {
        return timeAttacked;
    }

    /**
     * Get the type of the unit
     * @return name of the unit
     */
    public String getName(){
        return this.name;
    }

    /**
     * Get attack of this unit
     * @return attack of the unit
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * Get amount of armor to the unit
     * @return armor if the units
     */
    public int getArmor(){
        return this.armor;
    }

    /**
     * Set the amount of health to the unit
     * @param health the amount of health, if below 0 the health is set to 0
     */
    public void setHealth(int health){
        if(health>=0){
            this.health = health;
        }else{
            this.health = 0;
        }
    }

    /**
     * Set the name of the unit
     * @param name name of the unit, cannot be "" and not null
     */
    protected void setName(String name){
        if (!name.isEmpty()&&name!=null){
            this.name = name.strip().toLowerCase(Locale.ROOT);
        }else{
            this.name = "Invalid name";
        }
    }

    /**
     * Set attack of the unit
     * @param attack the attack of the unit
     */
    protected void setAttack(int attack){
        if(attack>0) {
            this.attack = attack;
        }else{
            this.attack = 0;
        }
    }

    /**
     * Set the amount of armor to the unit
     * @param armor value resembling damage resistance
     */
    protected void setArmor(int armor){
        if(armor >0) {
            this.armor = armor;
        }else{
            this.armor = 0;
        }
    }

    /**
     * Get a standard format to view the class
     * @return format for viewing the class
     */
    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                '}';
    }

    /**
     * Attack a given enemy unit, if the attack reduces the enemy's health below 0, the new health to the enemy will be set to 0
     * @param enemyUnit the enemy unit this unit attacks
     */
    public void attack(Unit enemyUnit){
        int newHealth = enemyUnit.getHealth() - (this.attack + this.getAttackBonus()) + (enemyUnit.getArmor() + enemyUnit.getResistanceBonus());
        if (newHealth<0){
            enemyUnit.setHealth(0);
        }else if(newHealth<this.getHealth()){
            enemyUnit.setHealth(newHealth);
        }
    }
}

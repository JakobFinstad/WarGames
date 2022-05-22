package no.ntnu.iir.jakobfin.data;

import java.util.Locale;

/**
 * Abstract class for creating instance of units, with set and get methods.
 *
 * @author 10007
 * @version 10.02.2022
 */
public abstract class Unit {

    protected String name;
    protected int health;
    protected int attack;
    protected int armor;
    protected int timeDefended = 0;
    protected int timeAttacked = 0;
    private Biomes terrain;

    /**
     * Constructor for objects witch inherits from this class.
     *
     * @param name name of the unit
     * @param health the amount of start health to this unit
     * @param attack the amount of attack damage
     * @param armor a value that indicates the units resistance
     */
    public Unit(String name, int health, int attack, int armor){
        this.setName(name);
        this.setHealth(health);
        this.setArmor(armor);
        this.setAttack(attack);
        this.terrain = null;
    }

    /**
     * Get attack bonus.
     *
     * @return attack bonus
     */
    public abstract int getAttackBonus();

    /**
     * Get resistance bonus.
     *
     * @return resistance bonus
     */
    public abstract int getResistanceBonus();

    /**
     * Get the amount of hitpoints for this unit.
     *
     * @return health of then unit
     */
    public int getHealth(){
        return this.health;
    }

    /**
     * Get time defended.
     *
     * @return how many attacks this unit has defended against
     */
    public int getTimeDefended() {
        return timeDefended;
    }

    /**
     * Get time attacked.
     *
     * @return how many times this unit has attacked
     */
    public int getTimeAttacked() {
        return timeAttacked;
    }

    /**
     * Get the type of the unit.
     *
     * @return name of the unit
     */
    public String getName(){
        return this.name;
    }

    /**
     * Get attack of this unit.
     *
     * @return attack of the unit
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * Get amount of armor to the unit.
     *
     * @return armor if the units
     */
    public int getArmor(){
        return this.armor;
    }

    /**
     * Get the biome of this unit.
     *
     * @return the biome of the unit
     */
    public Biomes getTerrain(){
        return this.terrain;
    }

    /**
     * Set the amount of health to the unit.
     *
     * @param health the amount of health
     * @throws IllegalArgumentException throws if the health is below 0
     */
    public void setHealth(int health) throws IllegalArgumentException{
        if(health>=0){
            this.health = health;
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Set the name of the unit.
     *
     * @param name name of the unit, cannot be "" and not null
     * @throws IllegalArgumentException throws if name is null or empty
     */
    protected void setName(String name) throws IllegalArgumentException{
        if (name!=null&&!name.isEmpty()){
            this.name = name.strip().toLowerCase(Locale.ROOT);
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Set attack of the unit.
     *
     * @param attack the attack of the unit
     * @throws IllegalArgumentException throws if new attack is below 0
     */
    protected void setAttack(int attack) throws IllegalArgumentException{
        if(attack>=0) {
            this.attack = attack;
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Set the amount of armor to the unit.
     *
     * @param armor value resembling damage resistance
     * @throws IllegalArgumentException throws if the new armor is below 0
     */
    protected void setArmor(int armor) throws IllegalArgumentException{
        if(armor >=0) {
            this.armor = armor;
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Set the terrain of this unit.
     *
     * @param terrain the biome for this unit
     */
    public void setTerrain(Biomes terrain){
        this.terrain = terrain;
    }

    /**
     * Get a standard format to view the class.
     *
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
     * Attack a given enemy unit, if the attack reduces the enemy's health below 0, the method throws.
     *
     * @param enemyUnit the enemy unit this unit attacks
     * @throws IllegalArgumentException throws if the new health is below 0
     */
    public void attack(Unit enemyUnit) throws IllegalArgumentException{
        int newHealth = enemyUnit.getHealth() - (this.attack + this.getAttackBonus()) + (enemyUnit.getArmor() + enemyUnit.getResistanceBonus());

        try {
            if (newHealth < this.getHealth()) {
                enemyUnit.setHealth(newHealth);
            }
        }catch (IllegalArgumentException illegalArgumentException){
            enemyUnit.setHealth(0);
        }

        this.incrementTimeAttacked();
        enemyUnit.incrementTimeDefended();
    }

    /**
     * Increment the time attacked of this unit.
     */
    private void incrementTimeAttacked(){
        this.timeAttacked ++;
    }


    /**
     * Increment time defended of this unit.
     */
    private void incrementTimeDefended(){
        this.timeDefended ++;
    }
}

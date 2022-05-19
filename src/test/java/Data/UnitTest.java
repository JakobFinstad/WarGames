package Data;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class UnitTest {
    /**
     * Testing the constructor to unit, with a positive test.
     */
    @Test
    public void testConstructorPositive(){
        DummyUnit unit1 = new DummyUnit("Jakob",10,10,10);

        //Testing setter and getter for health
        assertEquals("jakob",unit1.getName());
        //Testing getter and setter for health
        assertEquals(10,unit1.getHealth());
        //Testing setter and getter for attack
        assertEquals(10,unit1.getAttack());
        //Testing setter and getter for armor
        assertEquals(10,unit1.getArmor());
    }

    /**
     * Negative test for the constructor of units. Checks
     * for invalid name, health, attack and armor.
     * Also checks the getter methods.
     */
    @Test
    public void testConstructorNegative(){
        DummyUnit unit2 = new DummyUnit("OK",-10,10,10);
        DummyUnit unit3 = new DummyUnit("",10,-10,10);
        DummyUnit unit4 = new DummyUnit(null,10,10,-10);

        //Testing negative health
        assertEquals(0,unit2.getHealth());
        //Testing name not null or empty
        assertEquals("Invalid name",unit3.getName());
        assertEquals("Invalid name", unit4.getName());
        //Testing negative health, armor and attack values
        assertEquals(0,unit2.getHealth());
        assertEquals(0,unit3.getAttack());
        assertEquals(0,unit4.getArmor());
    }

    /**
     * Testing timeAttacked and timeDefended for units. Testing their default
     * values and the incrementation after one attack is initiated.
     */
    @Test
    public void testTimeAttackedAndTimeDefended(){
        DummyUnit unit1 = new DummyUnit("Jakob",10,10,10);
        DummyUnit unit2 = new DummyUnit("Jakob",10,10,10);

        //Testing default values equals 0
        assertEquals(0,unit1.getTimeAttacked());
        assertEquals(0,unit1.getTimeDefended());

        unit1.attack(unit2);
        //Testing after one attack
        assertEquals(1,unit1.getTimeAttacked());
        assertEquals(0,unit1.getTimeDefended());
        assertEquals(1,unit2.getTimeDefended());
        assertEquals(0,unit2.getTimeAttacked());
    }

    /**
     * Testing the attack method. Checking if the health don't increment caused by weak attacks,
     * and also checks if the health don't drop below zero due to heavy attacks.
     */
    @Test
    public void testAttack(){
        DummyUnit unit1 = new DummyUnit("Jakob",5,10,10);
        DummyUnit unit2 = new DummyUnit("Jakob",10,10,10);
        DummyUnit unit3 = new DummyUnit("Jakob",10,1000,10);

        //Testing if the attack method works with weak attacks
        unit1.attack(unit2);
        assertEquals(10,unit2.getHealth());
        //Testing if the attack method works with heavy attacks
        unit3.attack(unit2);
        assertEquals(0,unit2.getHealth());
    }
}

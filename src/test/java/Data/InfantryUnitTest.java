package Data;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class InfantryUnitTest {

    InfantryUnit testInfatry = new InfantryUnit("Test",10,10,10);
    InfantryUnit attackingUnit = new InfantryUnit("Test2",10,30,30);

    @Test
    public void testConstructor(){
        InfantryUnit negativeHealth = new InfantryUnit("Test",-10,5,5);
        InfantryUnit negativeAttack = new InfantryUnit("Test",5,-10,5);
        InfantryUnit negativeArmor = new InfantryUnit("Test",5,5,-10);
        InfantryUnit positiveUnit = new InfantryUnit("Test",5,5,5);
        InfantryUnit negativeString = new InfantryUnit("",5,5,5);
    }

    @Test
    public void testAttack(){
        testInfatry.attack(attackingUnit);
    }

    @Test
    public void testGetAttack(){
        assertEquals(2,testInfatry.getAttackBonus());
    }

    @Test
    public void testGetResistance(){
        assertEquals(1,testInfatry.getResistanceBonus());
    }
}

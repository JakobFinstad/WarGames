package Data;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * A class that test the values of the infatryunits is set to right amount.
 *
 * @author 10007
 * @version 19.05.2022
 */
public class InfantryUnitTest {


    /**
     * test will <code>PASS</code> if the attack bonus is the default value
     *
     * test will <code>FAIL</code> if the attack bonus is not the default value
     */
    @Test
    public void testGetAttack(){
        InfantryUnit testInfatry = new InfantryUnit("name",10);
        assertEquals(2,testInfatry.getAttackBonus());
    }

    /**
     * test will <code>PASS</code> if the resist bonus is the default value
     *
     * test will <code>FAIL</code> if the resist bonus is not the default value
     */
    @Test
    public void testGetResistance(){
        InfantryUnit testInfatry = new InfantryUnit("name",10);
        assertEquals(1,testInfatry.getResistanceBonus());
    }
}

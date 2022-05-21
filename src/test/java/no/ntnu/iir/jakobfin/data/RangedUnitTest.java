package no.ntnu.iir.jakobfin.data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class to test the attack and resist bonus of the ranged unit.
 *
 * @author 10007
 * @version 19.05.2022
 */
public class RangedUnitTest {

    /**
     * test will <code>PASS</code> if the resist bonus decreases by every time defended and stops at the threshold, and the attack bonus stayes the same
     *
     * test will <code>FAIL</code> if the resist bonus doesn't decrease or the attack bonus are changing
     */
    @Test
    public void testAttackBonusAndResistBonus(){
        RangedUnit unit1 = new RangedUnit("ok",10);

        //Check for default values are correct'
        assertEquals(3,unit1.getAttackBonus());
        assertEquals(6,unit1.getResistanceBonus());
        //Check if the values changes according to planned result
        unit1.attack(unit1);
        assertEquals(3,unit1.getAttackBonus());
        assertEquals(4,unit1.getResistanceBonus());
        //Check if the values don't go under the threshold for bonuses
        unit1.attack(unit1);
        unit1.attack(unit1);
        assertEquals(2,unit1.getResistanceBonus());

    }

}

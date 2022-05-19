package Data;

import Function.Army;
import Function.UnitFactory;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * A class that test the cavalry unit class.
 *
 * @author 10007
 * @version 19.05.2022
 */
public class CavalryUnitTest {

    /**
     * test will <code>PASS</code> if the attack bonus changes after an attack as it should.
     *
     * test will <code>FAIL</code> if the attack bonus doesn't change after one attack
     */
    @Test
    public void testAttackAndResistBonus(){
        UnitFactory factory = new UnitFactory();
        Army army = new Army("testArmy");
        army.addAll(factory.createMultipleUnits("CavalryUnit","unit",10,4));
        assertEquals(1,army.getAllUnits().get(0).getResistanceBonus());
        assertEquals(6,army.getAllUnits().get(0).getAttackBonus());
        //Testing if the values changes after attack
        army.getAllUnits().get(0).attack(army.getAllUnits().get(1));
        assertEquals(2,army.getAllUnits().get(0).getAttackBonus());
        assertEquals(1,army.getAllUnits().get(0).getResistanceBonus());
    }

}
